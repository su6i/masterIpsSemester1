#!/usr/bin/env python
# -*- coding:utf-8 -*-
from flask import Flask, request, render_template
from pandas_datareader import data as web
from datetime import datetime, timedelta
import dataReader.reader as reader
import matplotlib.pyplot as plt
import plotly.graph_objs as go
from matplotlib import style
import pandas as pd
import yfinance
import json
# import sys
import os
# import re

# import plotly.offline as po


ROOT = os.getcwd()+"/"
DB = ROOT + "db/"


app = Flask(__name__)

@app.route('/')
def home():
    return render_template('home.html')

@app.route('/about')
def about():
    return """Hello guys, <br />
    <br />
    My name is Amir. I have a B.Sc. in Electronics and I just started my master in Computer Science for Scientists 
    in the Montpellier University in France.<br />
    You can find all my codes in my gitHub and gitLab. 
    Also you can find my resume in English, Français and Deutch in the LinkedIn.
    <br />
    <br />
    Best regards,<br />
    Amir SHIRALI POUR<br/><br/>
    <div class="row">
        <div class="column">
            <a href="https://github.com/su6i/">
            <img src="/static/resources/github.png" alt="gitHub" style="width:10%;height:auto;border:0;">
            </a>
        </div>
        <div class="column">
            <a href="https://gitlab.info-ufr.univ-montp2.fr/u/su6">
            <img src="/static/resources/gitlab.png" alt="gitLab" style="width:150px;height:50px;border:0;">
            </a>
        </div>
        <div class="column">
            <a href="https://www.linkedin.com/in/su6i/">
            <img src="/static/resources/linkedin.png" alt="LinkedIn" style="width:200px;height:50px;border:0;">
            </a>
        </div>
    </div>
    """

@app.route('/hello', methods=['POST', 'GET'])
def hello():
    user = request.form['phrase']
    return "Bonjour " + user

@app.route('/hello/<segment1>/<segment2>')
def hello1(segment1, segment2):
    return "Bonjour " + segment1 + " et " + segment2

@app.route('/menu')
def show_menu():
    return render_template('mymenu.html')

# curl http://localhost:5000/online
@app.route('/online/', methods=['POST', 'GET'])
def online():
    if request.method == "POST":
        style.use('ggplot')
        display = request.form['displayForm']
        readerForm = request.form['reader']
        tickers = request.form.getlist('tickers')
        start = request.form['start']
        end = request.form['end']
        if not (start or end):
            start = (datetime.now() - timedelta(1)).strftime('%Y-%m-%d')
            end = datetime.today().strftime('%Y-%m-%d')
        filter = request.form['filter']
        filter = reader.selectFilter(filter)

        for share in tickers:
            if readerForm =='yahoo':
                ticker = reader.readYahooFinance(share,start,end)
            elif readerForm =='pandas':
                ticker = reader.readPandas(share,start,end)
            df = ticker[['Open','High','Low','Close']]
            with open(f'{DB}{share}.csv','w') as csvFile:
                df.to_csv(csvFile, sep='\t')

            with open(f'{DB}{share}.csv','r') as csvFile:
                df = pd.read_csv(csvFile, sep='\t')

        if display == 'dataframe':
            show = {}
            # filtered = list(map(lambda x: {"ticker": ticker, "filtered price": x[filter]}, dataTicker))
            return render_template('online.html', df=df, tickers=tickers, start=start, end=end, filter=filter)

        elif display == 'matplot':
            for ticker in tickers:
                fig = go.Figure(data=[go.Candlestick(
                    x       =df['Date'],
                    open    =df['Open'],
                    high    =df['High'],
                    low     =df['Low'],
                    close   =df['Close'],
                    increasing_line_color= 'black', decreasing_line_color= 'red'
                    )])
                fig.update_layout(
                title='Python Project     Supervisor: Pierre POMPIDOR      Author: Amir SHIRALI POUR',
                yaxis_title= ticker + ' Stock',
                shapes = [dict(x0='2016-12-09', x1='2016-12-09', y0=0, y1=1, xref='x', yref='paper', line_width=2)],
                annotations=[dict(x='2016-12-09', y=0.05, xref='x', yref='paper', showarrow=False, xanchor='left', text='Increase Period Begins')])

                # fig.update_layout(xaxis_rangeslider_visible=False)
                fig.show()
            return render_template('online.html', start=start, end=end, tickers=tickers)
        else:
            return render_template('online.html')

        return render_template('online.html')
    else:
        return render_template('online.html')

# curl http://localhost:5000/finance/<ticker>
@app.route('/finance/', methods=['POST', 'GET'])
def finance():
    if request.method           == "POST":
        serializationsForm      = request.form['serializations']
        readerForm              = request.form['reader']
        marketsForm             = request.form.getlist('markets')
        tickerForm              = request.form.getlist('tickers')
        display                 = request.form.getlist('displayForm')
        selectedMarkets = reader.selectMarket(marketsForm)
        selectedDB = reader.selectDB(serializationsForm)
        combinationsDbMarkets   = reader.combinationsDbMarket(selectedMarkets, selectedDB)
        if readerForm == "wikipedia":       # write mode
            for market in selectedMarkets:
                data = reader.reader(market)
                reader.readWrite(combinationsDbMarkets,data,'w')
            data = reader.aggregation(marketsForm)
            tickers = reader.getTicker(tickerForm,data)
            lastUpdate = reader.lastUpdate(w=True)
        elif readerForm == "offline":       # Read local files
            data = reader.readWrite(combinationsDbMarkets,'','r')
            tickers = reader.getTicker(tickerForm,data)
            lastUpdate = reader.lastUpdate(w=False)

        return render_template('finance.html', tickers=tickers, lastUpdate=lastUpdate)
        # return "reader: "+reader+ ", serialization: "+ serialization+ ", Market: "+ str(marketList) +", ticker: "+str(tickerForm)+", Display: "+str(display)
    else:
        return render_template('finance.html', ticker=[])


@app.route('/financelist', methods=["GET"])
def financelist():
    markets = request.args.get('markets').split(",")
    serialization = request.args.get('serialization')
    searchTerm = request.args.get('q')
    tickers = reader.reader(reader.selectMarket(markets)[0])
    result = [{"id": key, **item} for key, item in tickers.items()
    if searchTerm.lower() in key.lower() or searchTerm.lower() in item["fullName"].lower() ]
    total_count = len(result)

    return {
        "total_count": total_count,
        "items": result
    }

@app.route('/graph/', methods=["POST", "GET"])
def graph():
    df = pd.read_csv('https://raw.githubusercontent.com/plotly/datasets/master/finance-charts-apple.csv')

    fig = go.Figure(data=[go.Candlestick(x=df['Date'],
                    open=df['AAPL.Open'],
                    high=df['AAPL.High'],
                    low=df['AAPL.Low'],
                    close=df['AAPL.Close'])])

    fig.show()

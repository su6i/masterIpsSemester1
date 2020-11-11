#!/usr/bin/env python3
# -*- coding:utf-8 -*-

# The module has a lot of funcions that can read 4 market data (S&P 500, NASDAQ, CAC40 and Tehran) and write all data in 
# 4 different files such as JSON, PICKLE, SQLite and MySQL.
#
# Author: Amir SHIRALI POUR
# Python project, 2019-2020, Master degree's in Computer Science for Scientists
# Projet Python, 2019-2020, Master en Informatique pour les Sciences (IPS)

from flask import Flask, request, render_template, jsonify
from pandas_datareader import data as web
from datetime import datetime
import mysql.connector
import bs4 as bs
import yfinance
import requests
import sqlite3
import pickle
import json
import sys
import os

ROOT = os.getcwd()+"/"
DB = ROOT + "db/"
print("ROOT: ", ROOT)
print ("DB: ",DB)


def reader(market):
    tickers = {}
    if market == 1:                                 # 'sp500'
        print("This is reader(markets) when markets = 1 that means sp500 selected:")
        URL = 'https://en.wikipedia.org/wiki/List_of_S%26P_500_companies'
        source = requests.get(URL).text
        soup = bs.BeautifulSoup(source, "lxml")
        table = soup.find('table', {'class': 'wikitable sortable'})
        for row in table.findAll('tr')[1:]:
            ticker = row.findAll('td')[0].text[:-1]
            fullName = row.findAll('td')[1].text
            sector = row.findAll('td')[3].text
            subSector = row.findAll('td')[4].text
            headquarters = row.findAll('td')[5].text
            dateFirstAdded = row.findAll('td')[6].text
            founded = row.findAll('td')[8].text.strip()
            tickers[ticker] = {
                                "fullName" : fullName,
                                "sector" : sector,
                                "subSector" : subSector,
                                "headquarters" : headquarters,
                                "dateFirstAdded" : dateFirstAdded,
                                "founded" : founded
                                }

    elif market == 2:                               # 'nasdaq'
        print("This is NASDAQ:")
        print("You selected NASDAQ market but for instance this is not available.")
        tickers['ticker'] = {
                                "fullName" : 'fullName',
                                "sector" : 'sector',
                                "subSector" : 'subSector',
                                "headquarters" : 'headquarters',
                                "dateFirstAdded" : 'dateFirstAdded',
                                "founded" : 'founded'
                                }

    elif market == 3:                                 # 'cac40'
        URL = 'https://en.wikipedia.org/wiki/CAC_40'
        source = requests.get(URL).text
        soup = bs.BeautifulSoup(source,'lxml')
        table = soup.find('table',class_='wikitable sortable')
        rows = table.findAll('tr')
        for row in rows[1:]:
            ticker = row.findAll('td')[2].text.strip()
            fullName = row.findAll('td')[0].text
            sector = row.findAll('td')[1].text
            tickers[ticker] = {
                                "fullName" : fullName,
                                "sector" : sector,
                                "subSector" : 'subSector',
                                "headquarters" : 'headquarters',
                                "dateFirstAdded" : 'dateFirstAdded',
                                "founded" : 'founded'
                                }
    elif market == 4:                               # 'tehran'
        print("You selected Tehran market but for instance this is not available.")
        tickers['ticker'] = {
                                "fullName" : 'fullName',
                                "sector" : 'sector',
                                "subSector" : 'subSector',
                                "headquarters" : 'headquarters',
                                "dateFirstAdded" : 'dateFirstAdded',
                                "founded" : 'founded'
                                }
    else:
        print("Something is wrong!!")

    if tickers:
        return tickers
    else:
        return "wrongTicker"

def lastUpdate(w=False):
    if w == True:
        lastUpdate = datetime.today().strftime('%Y-%m-%d-%H:%M:%S')
        with open(DB+"lastUpdate.json","w") as lastFile:
            json.dump(lastUpdate, lastFile)
    else:
        if os.path.isfile(DB+'lastUpdate.json'):
            with open(DB+"lastUpdate.json") as lastFile:
                lastUpdate = json.load(lastFile)
        else:
            lastUpdate = '1000-01-01'
    return lastUpdate

def getTicker(tickers,data):
    out = []
    for ticker in tickers:
        if ticker.upper() in data:
            share = {"Company's Name": data[ticker.upper()]['fullName'], "Sector": data[ticker.upper()]['sector'], "Sub Sector": data[ticker.upper()]['subSector']}
            out.append(share)
    return out

# def selectMarket(*market):
#     marketList = list(map(writeIn(), market))
#     return marketList

def openSQLiteDB():
    with open(DB + combinationsDbMarket[0]+ "." + combinationsDbMarket[1],"w") as sqliteOut:
        conn = sqlite3.connect(sqliteOut) # connect to the database or create it if it doesn't exist before
        c = conn.cursor() # use this cursor object to run sql commands
    return c,conn

def createTableSQLite():
    c,_ = openSQLiteDB()
    c.execute("CREATE TABLE IF NOT EXISTS SP500 (ticker TEXT, companiesName TEXT, sector TEXT, subSector TEXT)")

def dataEntry(*args):
    c,_ = openSQLiteDB()
    c.execute("INSERT INTO SP500 VALUES (ticker, companiesName,sector,subSector)")

def mysqlConnect():
    mydb = mysql.connector.connect(
    host="localhost",
    user="amir",
    passwd="amir",
    database="IPSPythonProject"
    )

# The selectDB(serializations) function is to be sure that we can not select anything else except elements in the list (manually)and
# always we have a default value.
def selectDB(serializations):
    db = {'json': 1, 'pickle': 2, 'sqlite': 3, 'mysql': 4}
    serializationResult = db.get(serializations, 1)
    return serializationResult

# The selectMarket(markets) function is to be sure that we can not select anything else except elements in the list (manually) and
# always we have a default value.
def selectMarket(markets):
    marketResult=[]
    db = {'sp500': 1, 'nasdaq': 2, 'cac40': 3, 'tehran': 4}
    for market in markets:
        marketResult.append(db.get(market, 4))
    return marketResult


def selectFilter(filter):
    db = {'Open': ['Open'], 'High': ['High'], 'Low': ['Low'], 'Close': ['Close'], 'all': ['Open','High','Low','Close']}
    filter = db.get(filter, 'all')
    return filter

def aggregation(markets):
    print("I'm in the aggregation!!!")
    selectedMarkets = selectMarket(markets)
    data = {}
    print("selectedMarkets:", selectedMarkets)
    for selectedMarket in selectedMarkets:
        print("market:",selectedMarket)
        data = {**reader(selectedMarket), **data}
    print("data in aggregation:", data)
    return data

def readYahooFinance(ticker,start,end):
    df = web.DataReader(ticker, "yahoo", start, end)
    return df

def readPandas(ticker,start,end):
    df = yfinance.download(ticker,start,end)
    return df


# We have 16 different combinations pair, in each pair, first element is market (between 1 and 4) that comes from 
# the selectMarket(markets) function and second element is serialization type (between 1 and 4) that comes from 
# the selectDB(serializations) function.
def combinationsDbMarket(marketResult, serializationResult):
    combinationsDbMarkets = [(m, serializationResult) for m in marketResult]
    return combinationsDbMarkets

# The readWrite(combinationsDbMarkets,data,mode) will write in all combinations that we chose in the form.
# The output will be the files in JSON, Pickle, SQLite or MySQL format.
def readWrite(combinationsDbMarkets,data,mode):
    print("I'm in the readWrite in reader!")
    print("combinationsDbMarkets????", combinationsDbMarkets, "data???",data, "mode???",mode)
    for combinationsDbMarket in combinationsDbMarkets:
        print("combinationsDbMarket:::", combinationsDbMarket)
        fileAddress = DB + 'sp500'
        if combinationsDbMarket[0] == 1:            # Market = SP500
            data = reader(1)
            if combinationsDbMarket[1] == 1:            # combinationsDbMarket[1] = serialization and 1 means: 'json'
                file = fileAddress + ".json"
                if mode =='w':
                    with open(file , "w") as jsonFile:
                        json.dump(data, jsonFile, indent=2)
                        print("I wrote in",jsonFile)
                else:
                    if os.path.isfile(file):
                        with open(file) as file:
                            data = json.load(file)
                            return data

            if combinationsDbMarket[1] == 2:         # Pickle
                file = fileAddress + ".pickle"
                if mode =='w':
                    with open(file , "wb") as pickleFile:
                        pickle.dump(data,pickleFile)
                        print("I wrote in",pickleFile)
                else:
                    with open(file, "rb") as file:
                        data = pickle.load(file)
                        return data

            # if combinationsDbMarket[1] == 3:         # SQLite
            #     file = fileAddress + ".db"
            #     c, conn = openSQLiteDB()
            #     createTableSQLite()
            #     for ticker in tickers:
            #         dataEntry(ticker, companiesName,sector,subSector)

            #     if market == 'reader(sp500), j':
            #         pass
            #     conn.commit() # commit changes
            #     c.close()
            #     conn.close()

            # if combinationsDbMarket[1] == 4:         # MySQL
            #     print("I will write in mysql!!!!")

        if combinationsDbMarket[0] == 3:            # Market = CAC40
            data = reader(3)
            fileAddress = DB + 'cac40'
            if combinationsDbMarket[1] == 1:            # combinationsDbMarket[1] = serialization and 1 means: 'json'
                file = fileAddress + ".json"
                if mode =='w':
                    with open(file , "w") as jsonFile:
                        json.dump(data, jsonFile, indent=2)
                        print("I wrote in",jsonFile)
                else:
                    if os.path.isfile(file):
                        with open(file) as file:
                            data = json.load(file)
                            return data

            if combinationsDbMarket[1] == 2:         # Pickle
                file = fileAddress + ".pickle"
                if mode =='w':
                    with open(file , "wb") as pickleFile:
                        pickle.dump(data,pickleFile)
                        print("I wrote in",pickleFile)
                else:
                    with open(file, "rb") as file:
                        data = pickle.load(file)
                        return data

            # if combinationsDbMarket[1] == 3:         # SQLite
            #     file = fileAddress + ".db"
            #     c, conn = openSQLiteDB()
            #     createTableSQLite()
            #     for ticker in tickers:
            #         dataEntry(ticker, companiesName,sector,subSector)

            #     if market == 'reader(sp500), j':
            #         pass
            #     conn.commit() # commit changes
            #     c.close()
            #     conn.close()

            # if combinationsDbMarket[1] == 4:         # MySQL
            #     print("I will write in mysql!!!!")
                # mycursor = mydb.cursor()
                # mycursor.execute("CREATE DATABASE IPSProject")
                # mydb.commit()

                # mycursor.execute("SHOW TABLES")
                # #for x in mycursor:
                # #    print(x)
                # #mycursor.execute("SELECT User, Host, authentication_string FROM mysql.user;")
                # sql = "INSERT INTO customers (name, address) VALUES (%s, %s)"
                # val = ("John", "Highway 21")
                # mycursor.execute(sql, val)

                # mydb.commit()

                # print(mycursor.rowcount, "record inserted.")
                # mycursor.close()
                # mydb.close()



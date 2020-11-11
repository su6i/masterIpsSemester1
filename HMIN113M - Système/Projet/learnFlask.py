#!/usr/bin/env python
# -*- coding:utf-8 -*-
from flask import Flask, request, render_template
import os, json, re,sys

app = Flask(__name__)


# ----------------------------------------
# You can use "curl -v URL" to see the result in the verbose mode (with details)
# Example: curl -v curl http://localhost:5000/
# Example2: curl -v http://localhost:5000/hello/Wen
# Example3: curl -v http://localhost:5000/Bonjour/Aissatou/Maewa

# An example of having two route to show the same result
# to see the result you can use the below command in the terminal
# curl http://localhost:5000/ or http://localhost:5000/index/
@app.route('/')
def root():
    return "Hello guys, this is a simple example of flask server with some parameters."

# An example of having multiline result
# to see the result you can use the below command in the terminal
# curl http://localhost:5000/multiline
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
            <a href="https://gitlab.info-ufr.univ-montp2.fr/">     
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

# to see the result you can use the below command in the terminal
# curl http://localhost:5000/hello/Wen
# partie fixe (hello) et partie variable
@app.route('/hello/<phrase>')  
def hello(phrase):
    return "Bonjour "+phrase

# An example with two parameters.
# to see the result you can use the below command in the terminal
# curl http://localhost:5000/hello/Cherif/Sadi
@app.route('/hello/<segment1>/<segment2>')
def hello2(segment1, segment2):
    return "Bonjour "+segment1+" et "+segment2

# The next two examples are to show the difference between lowercase and uppercase uses in the fixed part of command
# Attention: "bonjour" in written with lowercase.
# to see the result you can use the below command in the terminal
# curl http://localhost:5000/bonjour/Luke/Alexian
@app.route('/bonjour/<segment1>/<segment2>')
def hello3(segment1, segment2):
    return "Hi guy: "+segment1+" I'm "+segment2

# Attention: "Bonjour" in written with uppercase.
# to see the result you can use the below command in the terminal
# curl http://localhost:5000/Bonjour/Aissatou/Maewa
@app.route('/Bonjour/<segment1>/<segment2>')
def hello4(segment1, segment2):
    return "Hi "+segment1+" this is to say Bonjour to "+segment2



# If you need to create static pages, you have to put your files in the "templates" folder!
# You can see three examples in below. All three files (home.html, index.html and indexFinance.html)
# are in the "templates" folder.
# curl http://localhost:5000/home
@app.route('/home/')
def home():
    return render_template('home.html')

# curl http://localhost:5000/linux
@app.route('/linux/')
def linux():
    return render_template('index.html')

# curl http://localhost:5000/finance
@app.route('/finance/')
def finance():
    return render_template('indexFinance.html')

# curl http://localhost:5000/menu
@app.route('/menu/')
def menu():
    return render_template('menu.html')



if __name__ == '__main__':
    app.run(port=12345, debug=True)
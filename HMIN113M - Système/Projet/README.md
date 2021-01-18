# Finance with Python
This is the final project of `Operating System - Python` course, first semester of master of Computer Science, Montpellier University. 
- This project is hosted in my website at https://www.learnhow.ir

## Supervisor:
    - Pierre POMPIDOR

## Author:
    - Amir SHIRALI POUR

----------------------------------------------------------------------------
Some photo examples:


![FaceBook](/HMIN113M%20-%20Système/Projet/static/resources/pic/fb.png)
![Google](/HMIN113M%20-%20Système/Projet/static/resources/pic/google.png)
![Microsoft](/HMIN113M%20-%20Système/Projet/static/resources/pic/msft.png)
![ADBE](/HMIN113M%20-%20Système/Projet/static/resources/pic/adbe.png)

----------------------------------------------------------------------------
### Thanks to my professors and this project I learned to:

1- How to create resizeable div (body part of html).   
2- Create serverside autocomplete and multiselectional search box.   
3- Web scraping using Beautifulsoup.   
4- Getting financial dataframe using Pandas and Yahoo Finance.   
5- Using functional programming.   
6- RESTful api using Jinja2 template engine and Flask framework.   
7- Using Virtual environment and creating requirement.txt file to have more portability.   
8- Creating Python module to reduce coding.   
9- Version controling by GitHub and using Markdown language.    
10- Putting the project on the Python host.   
11- Activating SSL for the website.    

### 1. How to make modules in Python?
- Make an empty file with the name `__init__.py` in your module's folder.

### 2. How to install virtual environment in Python?
    - python3 -m venv /path/to/new/virtual/environment

### 3. How to make "requirements.txt" file?
    - pip freeze > requirements.txt

### 4. How to install all requirements modules?
    - pip install --user --requirement requirements.txt

### . What is BeautifulSoup use for?
- Beautiful Soup is a Python package for parsing HTML and XML documents that makes it easy to scrape 
information from web pages.
- It's providing Pythonic idioms for iterating, searching, and modifying the parse tree

### . What is Python Pickle?
- The pickle module implements binary protocols for serializing and de-serializing a Python object structure.

### . Pickle vs JSON:
- JSON is a text serialization format and human-readable, while pickle is a binary serialization format.
- JSON is interoperable and widely used outside of the Python ecosystem, while pickle is Python-specific.
- JSON, by default, can only represent a subset of the Python built-in types, and no custom classes; 
pickle can represent an extremely large number of Python types (many of them automatically, by clever 
usage of Python’s introspection facilities; complex cases can be tackled by implementing specific object APIs).
- Unlike pickle, deserializing untrusted JSON does not in itself create an arbitrary code execution vulnerability.

### . SQLite vs MySQL:
- SQLite:
    - is a server-less database, file-based and is self-contained.
    - It is an embedded database which means the DB engine runs as a part of the app.
    - It is extremely portable and reliable.
    - It supports only one application at a time changing the database.
    - Single user on the local machine.
    - open source RDBMS.
    - The SQLite library is about 250 KB in size.
    - SQLite does not have an inbuilt authentication mechanism.
    
- MySQL:
    - Database server shared by multiple people
    - is secure.
    - open source RDBMS.
    - MySQL server is about 600 MB in size.


### . How to change the port of flask server?
- You can add `port=8888` in the this line `app.run(port=8888, debug=True)`
- `debug=True` means you can change your server without need to restart it for changes to take effect.

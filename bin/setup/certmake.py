#!/usr/bin/env python3
# -*- coding: UTF-8 -*-

import os, sys, time

os.system('clear')
print('Please enter the info below. Save the PASSWORD!')
time.sleep(7)
os.system('openssl req -newkey rsa:2048 -nodes -keyout key.pem -x509 -days 1365 -out cert.pem')
os.system('openssl x509 -text -noout -in certificate.pem')
os.system('openssl pkcs12 -inkey key.pem -in cert.pem -export -out cert.p12')
os.system('openssl pkcs12 -in cert.p12 -noout -info')
os.system('sudo mv cert.p12 web/certs')
os.system('sudo mv cert.pem web/certs')
os.system('sudo mv key.pem web/certs')
os.system('sudo mv certmake.py web/certs')

#!/usr/bin/python

import shutil
import os
import datetime

today = datetime.date.today()
base = 'vaje_%04d_%02d_%02d' % (today.year, today.month, today.day)
me = os.path.join(base, 'me')
assistant = os.path.join(base, 'assistant')

if not os.access(base, os.F_OK):
    os.mkdir(base)

if not os.access(me, os.F_OK):
    os.mkdir(me)

if not os.access(assistant, os.F_OK):
    os.mkdir(assistant)

shutil.copy('BranjePodatkov.class', me)
shutil.copy('BranjePodatkov.class', assistant)

os.system("java -jar as2client.jar 212.235.182.61 -d " + base)


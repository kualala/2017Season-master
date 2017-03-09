
# This script takes the picture on Picam and Store it in to local folder
# LOGIC
# 1. Start Camera Preview
# 2. Starts a for loop of 5 iterations
# 3. Sleep 10 seconds to focus and than take a picture,
#    store it under sanps folder with the loop-number.jpg
# 
# #Author: Esha Prasad eshanov9@gmail.com
##

from picamera import PiCamera
from time import sleep


camera = PiCamera()

# min resoution 64,64  
# camera.resolution = (2592,1944)
# camera.framerate = 15



camera.start_preview()
for i in range(5) :
    sleep(10)
#    now = datetime.datetime(now)
#    x = str(now)
    camera.capture('snaps/%s.jpg' % i)
camera.stop_preview()

# now = datetime.datetime(now)
# print str(now)

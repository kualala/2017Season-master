
# This script streams the camera view on to the monitor for 10 seconds
# 
# #Author: Esha Prasad eshanov9@gmail.com
##

from picamera import PiCamera
from time import sleep

camera = PiCamera()

camera.start_preview()
sleep(10)
camera.stop_preview()

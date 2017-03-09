
# This script records HD video for 5 seconds and
# stores it under video folder with v1.h264 filename
# 
# #Author: Esha Prasad eshanov9@gmail.com
##

from picamera import PiCamera
from time import sleep

camera = PiCamera()

camera.start_preview()
camera.start_recording('video/v1.h264')
sleep (5)
camera.stop_recording()
camera.stop_preview()

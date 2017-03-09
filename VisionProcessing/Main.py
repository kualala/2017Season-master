
# This is the main loop for all the vision processing group
# LOGIC:
# 1.Get and store image from camera
# 2.Process image and get distance vector
# 3.Send to RoboRIO over TCP socket.
#
# #Author: Nikhil Aggarwal, nikhil029@gmail.com, i am reall cool
##
import time # for sleep
import datetime

SLEEPSECS = 5
IMAGE_DIR = "frcImages"
imageFile = "" # imageFile is set by camera routine
x = y = z = 0
ts = 0 # timestamp NEED TO DETERMINE FORMAT AND IF IT IS AN INT OR A STRING

stime = datetime.datetime.now()

print("Starting image processing at " + str(stime))
while(True):

    # input: none
    # output: filename of image or empty string on Error
    stime = datetime.datetime.now()
    imageFile = take_and_store_photo() ##### Esha's function
    timedelta = datetime.datetime.now() - stime;
    print("completed image capture in " + str(timedelta))

    # input: filename of image
    # output: coordinates and timestamp
    stime = datetime.datetime.now()
    (x, y, z, ts) = process_image()  #####   NikhilM + Eva function
    timedelta = datetime.datetime.now() - stime;
    print("completed image processing in " + str(timedelta))


    # input: coordinates and timestamp
    # output: send to Java server on RoboRIO
    stime = datetime.datetime.now()
    send_coordinates(x, y, z, ts)
    timedelta = datetime.datetime.now() - stime;
    print("completed send_coordinates in " + str(timedelta))

    time.sleep(SLEEPSECS)

print("program exiting") # should not reach this
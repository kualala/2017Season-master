# This code connects to the RoboRIO java controller over a TCP socket and sends coordinates.
# This is part of the Vision Processing software for FRC team 5905
#
# Author: Nikhil Aggarwal, nikhil0929@gmail.com, Jan 28, 2017
#
import socket
import sys

# GLOBAL VARIABLES
SERVER_HOST = "localhost"
SERVER_SOCKET = 5905
SERVER_PASSWORD = "r0b0c0rps"
loginStatus = False
debug = False
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

##
# Log into the remote TCP server and keep the connection open
def login():
    global loginStatus

    if loginStatus:
        return

    client_socket.connect((SERVER_HOST, SERVER_SOCKET))
    reply = client_socket.recv(4096)
    if debug:
        print ("debug Initial Connection GOT " + reply.decode(encoding='UTF-8'))

    client_socket.send((bytes("LOGIN " + SERVER_PASSWORD + "\n", encoding="UTF-8")))
    reply = client_socket.recv(4096)
    strReply = reply.decode(encoding='UTF-8')
    if strReply[:2] == "OK":
        loginStatus = True
        if debug:
            print ("debug Logged in successfully\n")
    else:
        print (strReply)

    return

##
# Issue Logout command to remote server if connected
def logout():
    global loginStatus

    if loginStatus != True:
        return
    client_socket.send((bytes("LOGOUT\n", encoding="UTF-8")))
    loginStatus = False
    return

##
# Send coordinates and Timestamp. All are integers except ts (timestamp)
def send_coordinates(x, y, z, ts):
    login()
    if loginStatus != True:    # some error in logging in.
        print ("Error - could not login")
        return

    command = "CURRENT_LOCATION " + str(x) + " " + str(y) + " " + str(z) + " " + ts + "\n"
    client_socket.send((bytes(command, encoding="UTF-8")))
    reply = client_socket.recv(4096)
    strReply = reply.decode(encoding='UTF-8')
    if strReply[:2] == "OK":
        print("coordinates sent successfully!\n")
    else:
        print(strReply)
    return

### MAIN  ###
if __name__ == "__main__":
    debug = True
    send_coordinates(10, 2, 34, "10/10/2011")
    logout()

'''
while True:

    data = input("Type QUIT to exit -> ")
    data = data + "\n"
    if data != 'QUIT\n':
        try:
            # Set the whole string
            client_socket.send(bytes(data, encoding="UTF-8"))
        except socket.error:
            # Send failed
            print ('Send failed')
            sys.exit()
        print ('Message send successfully')

        # Now receive data
        reply = client_socket.recv(4096)
        print ("recv " + reply.decode(encoding='UTF-8') + "\n")
    else:
        client_socket.send(bytes(data, encoding="UTF-8"))
        client_socket.close()
        break;
        '''

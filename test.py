import you_get
import sys

def Fuc():
    sys.argv=['you-get','-u','https://www.youtube.com/watch?v=auVqxpwHkVs']
    print(sys.argv)
    you_get.main()



if __name__ == '__main__':
    Fuc()

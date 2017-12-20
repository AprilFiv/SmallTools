import sys
import you_get

def test():
    sys.argv=['you-get','-u','https://www.youtube.com/watch?v=9HkeZ8w4z6c']
    you_get.main()
if __name__ == '__main__':
    test()

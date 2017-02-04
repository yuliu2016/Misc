def do():
    line=" "
    num=1
    r=""
    il={}
    while line:
        line= raw_input("line "+str(num)+":")
        il[num]=line
        num+=1
    size=input("size:")
    for i in il.keys():
        total=""
        totals=""
        for j in il[i]:total+=j*size
        for k in range(size):totals+=total+"\n"
        r= r+totals
    return r

while True:print do()

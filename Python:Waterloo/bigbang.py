def shift(l,s):
    l=l.upper()
    a="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    si=a.index(l)+s
    x=0
    if si <=-1:x=1
    elif si >=26:x=-1
    while x:
        si+=26*x
        x=0
        if si <=-1:x=1
        elif si >=26:x=-1
    return a[si]
def encode(k,w):
    global shift
    n=""
    for i in range(len(w)):
        s=3*(i+1)+k
        l=shift(w[i],s)
        n+=l
    return n
def decode(k,w):
    global shift
    n=""
    for i in range(len(w)):
        s=(3*(i+1)+k)*-1
        l=shift(w[i],s)
        n+=l
    return n

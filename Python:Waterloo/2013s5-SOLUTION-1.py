def main():
    N,cost=input(),0
    while N>1:
        r,f=int(N**0.5)+1,2
        while f<=r and N%f!=0:f+=1
        if f<N and N%f==0:
            x=N/f
            N-=x
            cost+=N/x
        else:
            N=N-1
            cost=cost+N
    print cost
while 1:main()

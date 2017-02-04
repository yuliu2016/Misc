class Level:
    
    def __init__(self,a,b):
        self.a=a
        self.b=b
        self.children=[]
        self.index=0
        
    def ac(self,e):
        if not e in self:
            self.children.append(e)
            
    def next(self):
        self.index += 1
        return self.children[self.index-1]
    
    def __contains__(self,o):
        for i in self.children:
            a=[o.a,o.b]
            if (i.a and i.b) in a:
                return True
        return False

    
class Factor:
    
    def __init__(self,number):
        self.number=number
        self.fl=[]

        a=1
        b=(self.number-self.number%2)/2
        while a<=b:
            if self.number%a==0:
                self.fl.append(a)
            a+=1
        if self.fl==[]:self.fl=[1,1]
        else: self.fl.append(self.number)
        
            
    def getp(self):
        a=self.fl[0]
        b=self.fl[-1]
        del self.fl[0]
        del self.fl[-1]
        return (a,b)


class Path:
    
    def __init__(self):
        self.ti=[]
        self.n=2
        self.cost=1

    def add(self,lev):
        self.ti.append(lev)
        self.n+=lev.a
        self.cost+=lev.b

    def up(self):
        if self.ti==[]:return True
        lev=self.ti[-1]
        self.n-=lev.a
        self.cost-=lev.b
        del self.ti[-1]
        return False


#=================================================================

    
def main(n):
    import copy
    best=Path()
    p=Path()
    p.add(Level(1,1))
    done=False
    while not done:
        while True:
            f=Factor(p.n)
            for i in range(len(f.fl)/2):
                level=Level(*f.getp())
                try:
                    print "1 B TRY: [",len(p.ti),"]",p.n,p.cost
                    p.ti[-1].ac(level)
                    print "1 A TRY: [",len(p.ti),"]",p.n,p.cost
                except:
                    print "1 R EXC: [",len(p.ti),"]",p.n,p.cost
                    done=True
                    break
                    
            try:
                print "2 B TRY: [",len(p.ti),"]",p.n,p.cost
                x=p.ti[-1].next()
            except:
                print "2 B EXC: [",len(p.ti),"]",p.n,p.cost
                done=p.up()
                print "2 A EXC: [",len(p.ti),"]",p.n,p.cost
                break
            else:
                p.add(x)
                print "2 A TRY: [",len(p.ti),"]",p.n,p.cost
            if p.n>n:
                done=p.up()
                break
        if p.n==n:
            if best.cost<p.cost:
                best=copy.copy(p)
    return best.cost


if __name__=="__main__":pass

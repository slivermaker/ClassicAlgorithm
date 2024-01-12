#include<bits/stdc++.h>
using namespace std;
int n;
vector<vector<int>>g;
const int N=1510;
int f[N][2],d[N];
void dfs(int u)
{
    f[u][1]=1;f[u][0]=0;
    for(int &x:g[u])
    {
        dfs(x);
        f[u][1]+=min(f[x][0],f[x][1]);
        f[u][0]+=f[x][1];
    }
    
}
int main()
{
    cin>>n;
    g.resize(n);
    memset(d,0,sizeof d);
    int t,cnt;
    for(int i=0;i<n;i++)
    {
        scanf("%d:(%d)",&t,&cnt);
        while(cnt--)
        {
            int a;
            cin>>a;
            g[t].push_back(a);
            d[a]++;
        }
    }
    int root=0;
    while(d[root])root++;
    dfs(0);
    int res=min(f[0][0],f[0][1]);
    cout<<res<<endl;
    return 0;
}

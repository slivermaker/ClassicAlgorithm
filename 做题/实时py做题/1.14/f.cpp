#include <bits/stdc++.h>
using namespace std;
using ll = long long;
constexpr int mod = 1e9 + 7;
constexpr int N = 300010;

ll n, k, a[N], pre[N];

template<typename T>
struct BIT {
    T a[N];
    int size = N;
    void init (int s) {
         size = s;
         for (int i = 1; i <= s; i++) a[i] = 0;
    }
    T query(int x) {
        T s = 0;
        for (; x; x -= x & (-x)) {
            s += a[x];
        }
        return s;
    }
    void modify(int x, T s) {
        for (; x <= N; x += x & (-x)) {
            a[x] += s;
        }
    }
};
BIT<ll> bit;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cin.exceptions(cin.failbit);
    cin >> n >> k;
    //pre[i] - k >= pre[j]
    set<ll> st;
    map<ll, int> mp;
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
        pre[i] =  pre[i - 1] + a[i];
        st.insert(pre[i] - k);
        st.insert(pre[i]);
    }
    int i = 1;
    for (auto c : st) {
        mp[c] = i++;
    }
    ll ans = 0;
    for (int i = 1; i <= n; i++) {
        if (pre[i] >= k) ans++;
        bit.modify(mp[pre[i]], 1);
        ans += bit.query(mp[pre[i] - k]);
    }
    cout << ans;
    return 0;
}
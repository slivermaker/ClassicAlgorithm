#include <bits/stdc++.h>
using namespace std;
using ll = long long;
constexpr int mod = 1e9 + 7;

ll n, k, ans;

ll powmod (ll a, ll b) {
    ll res = 1;
    for ( ; b; b>>=1) {
        if (b & 1) res = res * a % mod;
        a = a * a % mod;
    }
    return res;
}
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cin.exceptions(cin.failbit);
    cin >> n >> k;
    int en = k / 2, od = k / 2 + (k & 1 ? 1 : 0);
    ans = (ans + powmod(en, n)) % mod;
    int s0 = n / 3, s1 = n / 3 * 2, sy = n % 3;
    if (sy == 0) {
        ans = (ans + powmod(en, s0) % mod * powmod(od, s1) % mod) % mod;
        ans = (ans + powmod(en, s0) % mod * powmod(od, s1) % mod) % mod;
        ans = (ans + powmod(en, s0) % mod * powmod(od, s1) % mod) % mod;
    } else if (sy == 1) {
        s0++;
        ans = (ans + powmod(en, s0) % mod * powmod(od, s1) % mod) % mod;
        s0--; s1++;
        ans = (ans + powmod(en, s0) % mod * powmod(od, s1) % mod) % mod;
        ans = (ans + powmod(en, s0) % mod *  powmod(od, s1) % mod) % mod;
    } else {
        s0++; s1++;
        ans = (ans + powmod(en, s0) % mod * powmod(od, s1) % mod) % mod;
        ans = (ans + powmod(en, s0) % mod * powmod(od, s1) % mod) % mod;
        s0--; s1++;
        ans = (ans + powmod(en, s0) % mod * powmod(od, s1) % mod) % mod;
    }
    cout << ans;
    return 0;
}
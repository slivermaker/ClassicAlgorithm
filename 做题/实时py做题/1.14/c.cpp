#include <bits/stdc++.h>
using namespace std;

int n, m, k, x, y, cnt[1100];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cin.exceptions(cin.failbit);
    cin >> n >> m >> k;
    for (int i = 1; i <= m; i++) cnt[i] = 1;
    set <array<int,2>> st;
    for (int i = 1; i <= k; i++) {
        cin >> x >> y;
        if (!st.count({x, y})) {
            st.insert({cnt[y], y});
            cnt[y]++;
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (st.count({i, j})) {
                cout << ".";
            } else {
                cout << "*";
            }
        }
        cout << "\n";
    }
    return 0;
}
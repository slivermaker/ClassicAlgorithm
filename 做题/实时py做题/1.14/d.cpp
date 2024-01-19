#include <bits/stdc++.h>
using namespace std;
using ll = long long;
constexpr int N = 100010;

int n;
ll k, a[N];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cin.exceptions(cin.failbit);
    cin >> n >> k;
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
    }
    ll ans = 0, sum = 0, j = 1;
    for (int i = 1; i <= n; i++) {
        if (sum < k) {
            sum += a[i];
            if (sum >= k) {
                ans += n - i + 1;
                while ((j <= i) && (sum >= k)) {
                    sum -= a[j];
                    j++;
                    if (sum < k) {
                        break;
                    }
                    ans += n - i + 1;
                }
            }
        }
        // cout << i << " " << j << " " << sum << " ";
        // cout << ans << "\n";
    }
    cout << ans;
    return 0;
}
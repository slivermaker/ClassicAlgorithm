#include <bits/stdc++.h>
using namespace std;
using ll = long long;
constexpr int N = 1000010;

ll n, W, weights[N], values[N], prefix_sum[N], current_sum, current_max, answer = -2e18;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin.exceptions(cin.failbit);

    cin >> n >> W;

    multiset<ll, greater<ll>> value_set;

    for (int i = 1; i <= n; i++) {
        cin >> weights[i];
    }

    for (int i = 1; i <= n; i++) {
        cin >> values[i];
        prefix_sum[i] = prefix_sum[i - 1] + values[i];
        value_set.insert(prefix_sum[i]);
    }

    int start_index = 1;

    for (int end_index = 1; end_index <= n; end_index++) {
        current_sum += weights[end_index];

        while (current_sum >= W && start_index <= end_index) {
            ll current_max_value = *value_set.begin();
            current_max_value -= prefix_sum[start_index - 1];
            answer = max(current_max_value, answer);
            current_sum -= weights[start_index++];
        }

        value_set.erase(value_set.find(prefix_sum[end_index]));
    }

    cout << answer << "\n";

    return 0;
}

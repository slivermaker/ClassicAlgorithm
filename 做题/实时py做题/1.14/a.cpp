#include <bits/stdc++.h>
using namespace std;


int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cin.exceptions(cin.failbit);
    int sum = 0;
    for (int i = 1, a; i <= 6; i++) {
        cin >> a;
        sum += a;
    }
    cout << sum;
    return 0;
}
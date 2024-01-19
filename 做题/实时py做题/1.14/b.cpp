#include <bits/stdc++.h>
using namespace std;

string s;
vector <string> vs;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0); cin.exceptions(cin.failbit);
    cin >> s;
    int n = s.size();
    if (n >= 2) {
        for (int i = 0; i < n - 1; i++) {
            vs.push_back(s.substr(i, 2));
        }
        sort(begin(vs), end(vs));
        for (auto c : vs) cout << c << "\n";
    } 

    return 0;
}
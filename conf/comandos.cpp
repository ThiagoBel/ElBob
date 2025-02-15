#include <iostream>
#include <string>
using namespace std;

int main()
{
    string user;
    string disco = "bob>";
    cout << "El Bob comando" << endl;
    while (true)
    {
        cout << disco;
        getline(cin, user);
        
        if (user.find("say ") == 0)
        {
            string texto = user.substr(4);
            cout << texto << endl;
        }
        else
        {
            system(user.c_str());
        }
    }

    return 0;
}
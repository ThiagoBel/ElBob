#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main()
{
    string nomecpp;
    cout << "Digite o nome do arquivo(sem a extenção): ";
    getline(cin, nomecpp);
    
    ifstream codigoCPP(nomecpp + ".cpp");

    if (codigoCPP.is_open())
    {
        string rodar1 = "g++ " + nomecpp + ".cpp -o " + nomecpp + ".exe\n";
        string rodar2 = nomecpp + ".exe\n";

        system(rodar1.c_str());
        system(rodar2.c_str());
    }
    else
    {
        cout << "Erro!" << endl;
    }
    
    return 0;
}
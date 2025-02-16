#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main()
{
    string nomejava;
    cout << "Digite o nome do arquivo(sem a extenção): ";
    getline(cin, nomejava);
    
    ifstream codigoJAVA(nomejava + ".java");

    if (codigoJAVA.is_open())
    {
        string rodar1j = "javac " + nomejava + ".java\n";
        string rodar2j = "java " + nomejava + "\n";

        system(rodar1j.c_str());
        system(rodar2j.c_str());
    }
    else
    {
        cout << "Erro!" << endl;
    }
    
    return 0;
}
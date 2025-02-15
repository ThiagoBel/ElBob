#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main()
{
    string nomepy;
    cout << "Digite o nome do arquivo Python (sem a extensão): ";
    getline(cin, nomepy);
    
    ifstream codigoPY(nomepy + ".py");

    if (codigoPY.is_open())
    {
        string rodar = "python " + nomepy + ".py\n";
        system(rodar.c_str());
    }
    else
    {
        cout << "Erro!" << endl;
    }
    
    return 0;
}
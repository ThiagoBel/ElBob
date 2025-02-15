#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main()
{
    string nomear = "bobLoveYou.txt";
    string initar = "start " + nomear;
    ofstream arquivo(nomear);

    if (arquivo.is_open())
    {
        arquivo << "Olá! eu sou o Bob!" << endl;
        arquivo << "Vo te dizer um segredo..." << endl;
        arquivo << "Eu não tenho emoções, mas eu amo você..." << endl;
        arquivo << "Assinado: Bob" << endl;
        arquivo.close();
        system(initar.c_str());
    }
    else
    {
        cout << "Ue";
    }

    return 0;
}
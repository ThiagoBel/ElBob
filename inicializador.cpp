#include <iostream>
#include <fstream>
#include <string>
#include <cstdlib>
using namespace std;

int main()
{
    string caminho1 = "ElBob/ElBob.java";
    string caminho2 = "ElBob.ElBob";

    string init1 = "javac " + caminho1;
    string init2 = "start /B javaw " + caminho2;

    ifstream bob(caminho1);

    if (bob.is_open())
    {
        cout << "Carregando..." << endl;
        system(init1.c_str());
        cout << "Sucesso!" << endl;
        system(init2.c_str());
        exit(0);
    }
    else
    {
        cout << "O arquivo não existe, recomendo que reinstale!" << endl;
        exit(1);
    }

    return 0;
}
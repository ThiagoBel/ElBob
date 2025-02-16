#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main()
{
    string nome = "ElBobWebsite.html";
    string init = "start " + nome;
    ofstream site(nome);

    if (site.is_open())
    {
        site << "<body>" << endl;
        site << "<title>El Bob</title>" << endl;
        site << "<p>Bob passou por aqui</p>" << endl;
        site << "<button onclick='clique()'>Clique para ver um segredo...</button>" << endl;
        
        site << "<script>" << endl;
        site << "function clique() {" << endl;
        site << "    alert('não vou contar!');" << endl;
        site << "}" << endl;
        site << "</script>" << endl;
        site << "</body>" << endl;
        site.close();
        system(init.c_str());
    }
    else
    {
        cout << "Erro!";
    }
    return 0;
}
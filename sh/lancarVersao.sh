#/bin/bash

versao='1.2'

caminho=`pwd`
cd ..

git add .
git commit -m "Lançando versão ${versao}."
git tag -a ${versao} -m "Estória ${versao}"

cd ${caminho}

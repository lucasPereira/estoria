#/bin/bash

versao='1.1'
git add .
git commit -m "Lançando versão ${versao}"
git tag -a ${versao} -m "Estória ${versao}"

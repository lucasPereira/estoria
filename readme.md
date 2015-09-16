# Estória
Não é história, é estória estúpido.

## Documentação
A documentação desta biblioteca pode ser acessada através da [Wiki](https://github.com/lucasPereira/estoria/wiki).

## Licença
Esta biblioteca é de domínio público. Você pode copiar, modificar, publicar, usar, compilar, vender ou distribuir este software para qualquer proposito, comercial ou não comercial, e por qualquer motivo. A licença deste software é a [Unlicense](http://unlicense.org/). Para mais detalhes veja o arquivo `license.md`.
> O mundo é livre.

## Versões

### Versão 1.1 (16/09/2015)
* Redifinição da nomenclatura das classes de teste usadas como configuração (de @Acessorio para @FixtureSetup).
* Adição da anotação @Fixture que possibilita a injeção automática dos atributos configurados em uma classe que esteja dentro da anotação @FixtureSetup.
* Suporte à dependências indiretas entre classes de teste (referências indiretas de @FixtureSetup).

### Versão 1.0 (08/09/2015)
* Suporte às funcionalidades básicas do JUnit: @Test, @Before, @Ignore, @RunWith e @SuiteClasses.
* Adição da anotação @Acessorio que permite incluir os @Before`s de outra classe.
* Execução do metódo de teste mesmo se um ou mais métodos de configuração falharem.
* Exibição de ambas as falhas, do método de teste e do método de configuração, caso existam.
* Execução do Estória através do Eclipse.

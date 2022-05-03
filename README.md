# Vacinação em Bovinos
Dado um cenário de uma criação de gado, ou um simples morador rural que possui alguns bovinos, sabe-se que há dificuldade para armazenar e gerenciar os registros médicos e de vacinação desses animais.

Desse modo, este projeto implementa uma possível solução para lidar com os registros de vacinação dos bovinos. Um _software_ capaz de criar, armazenar e gerenciar os registros de vacinação para estes quadrúpedes, além de armazenar características físicas desses animais e as informações técnicas das vacinas aplicadas.

Repositório modelo para criação do Projeto Final da disciplina de Linguagem de Programação II do Instituto Metrópole Digital da UFRN, ministrada pelo Prof. Gustavo Leitão.

## Descrição

O _software_ desenvolvido em Java visa gerenciar a vacinação em Bovinos, além de armazenar informações acerca das vacinas aplicadas e também do animal.

No sistema é possível: adicionar doses das vacinas, realizar buscas por data ou nome da vacina aplicada, adicionar a alimentação e imprimir alimentação ou doses das vacinas. E caso seja fêmea, pode-se adicionar filhos, verificar a quantidade de filhos, buscar filhos por nome e imprimir filhos.

Em relação à vacina, as informações persistidas são: nome, dosagem em mililitros, fabricante, periodicidade em dias, data de aplicação e informações adicionais.

Já em relação aos bovinos, as informações armazenadas são: nome, data de nascimento, peso em quilogramas, se está doente, se possui chifres, espécie, sexo, cor, alimentação e seu registro de vacinação.

Além disso, algumas informações extras são armazenadas a depender do
sexo do animal. Caso seja fêmea, as informações adicionais são: produção de leite em litros por dia, se está grávida, e uma lista de seus filhos. Caso seja macho: se é reprodutor e se é castrado.

## Apresentação em Vídeo

[![](./imgs/vacinacao_bovinos_slide_1_with_player.jpg?raw=true)](https://youtu.be/WEWEuWUYDNE "Projeto Vacinação em Bovinos")

## Diagrama de Classes

![Diagrama de Classes](./imgs/cattle_diagram_uml.png?raw=true "Diagrama de Classes")

## Testes Automatizados

O projeto usa o ©Gradle como sistema de automação de compilação para build e execução de testes automatizados.

A equipe preparou testes automatizados para o software, para executá-los pode-se utilizar a interface do ©IntelliJ IDEA ou executar o seguinte comando no terminal:
```console
./gradlew :test
```

## Autores

<div>
<a href = "https://github.com/deboraazevedo/" target="_blank" style="vertical-align:middle"><img src="./imgs/GitHub.png"></a>
<span>&ensp; Débora Karoline Silva de Azevedo</span>
</div>

<div>
<a href = "https://github.com/usrjonas/" target="_blank" style="vertical-align:middle"><img src="./imgs/GitHub.png"></a>
<span style="">&ensp; Jonas de Oliveira Freire Filho</span>
</div>

<div>
<a href = "https://github.com/neylanepl/" target="_blank" style="vertical-align:middle"><img src="./imgs/GitHub.png"></a>
<span style="">&ensp; Neylane Pereira Lopes</span>
</div>

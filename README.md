# AppNutrição - Aplicativo de Nutrição

Este projeto é um aplicativo de nutrição desenvolvido como parte do trabalho semestral da disciplina de Programação para Dispositivos Móveis da FATEC-ZL, sob orientação do Prof. Leandro Colevati. O aplicativo oferece funcionalidades para gerenciar dados nutricionais e de saúde de pacientes, incluindo registro de informações alimentares, controle de dietas, e funcionalidades de CRUD.

## Funcionalidades

- **Cadastro de pacientes**: Permite o registro de informações de pacientes, como nome, idade, peso, altura, e outras informações relevantes.
- **Cadastro de alimentos**: Oferece a possibilidade de adicionar alimentos com informações nutricionais.
- **Controle de dieta**: O usuário pode acompanhar as dietas e planos alimentares recomendados para cada paciente.
- **Consultas**: Permite o usuário visualizar os registros de pacientes e alimentos cadastrados.

## Tecnologias

- **Linguagem**: Java
- **Framework**: Android Studio
- **Banco de dados**: SQLite

## 📷 Capturas de Tela
### 🔹 Tela de Login  
![Tela de Login](screenshots/tela_login.png)

### 🔹 Tela Inicial  
![Tela Inicial](screenshots/tela_inicial.png)

### 🔹 Cadastro de Paciente  
![Cadastro de Paciente](screenshots/cadastro_paciente.png)

### 🔹 Perfil do Paciente  
![Perfil do Paciente](screenshots/perfil.png)

### 🔹 Plano Alimentar  
![Plano Alimentar](screenshots/plano_alimentar.png)

### 🔹 Plano de Dieta Registrado  
![Plano de Dieta Registrado](screenshots/plano_dieta_registrado.png)

## Estrutura do Projeto

- **Pacote Model**: Contém as classes de modelo que representam os dados do aplicativo, como `Paciente`, `Alimento`, etc.
- **Pacote Controller**: Contém a lógica de controle do aplicativo, como os controladores responsáveis pelo CRUD.
- **Pacote View**: Responsável pela interface com o usuário, utilizando fragmentos para exibir as telas de cadastro e consultas.

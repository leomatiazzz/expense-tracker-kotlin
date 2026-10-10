# Expense Tracker Android 🇧🇷

Bem-vindo ao **Expense Tracker Android**! Este projeto foi desenvolvido para ajudar os usuários a controlar suas despesas diárias de maneira simples e prática.

O aplicativo permite adicionar, visualizar e analisar despesas por meio de estatísticas e gráficos intuitivos. Ele utiliza práticas modernas de desenvolvimento Android, incluindo **Jetpack Compose**, **Room Database**, **Dagger Hilt** para injeção de dependências e a arquitetura **MVVM**.

---

## ✨ Funcionalidades

- **Adicionar despesas:** registre suas despesas diárias com apenas alguns toques.
- **Acompanhar despesas:** visualize uma lista de todas as despesas cadastradas, organizadas por data e categoria.
- **Analisar gastos com estatísticas:** obtenha informações sobre seus hábitos de consumo por meio de estatísticas detalhadas e gráficos.

---

## 🛠️ Tecnologias Utilizadas

- **Kotlin:** linguagem de programação utilizada no desenvolvimento do aplicativo.
- **Jetpack Compose:** ferramenta moderna para a criação de interfaces nativas para Android.
- **Room Database:** camada de persistência de dados baseada no SQLite, utilizada para gerenciar informações localmente.
- **Dagger Hilt:** biblioteca de injeção de dependências para Android que simplifica a configuração e o gerenciamento das dependências.
- **Arquitetura MVVM:** padrão arquitetural que separa a interface do usuário, a lógica de negócios e o gerenciamento dos dados, facilitando a manutenção e a organização do código.

---

## 🏗️ Arquitetura e Estrutura do Projeto

O projeto é estruturado seguindo os princípios de *Clean Architecture* e separação de responsabilidades (MVVM):

- **Configuração e Injeção de Dependências:** Gerenciamento de ciclo de vida e dependências centralizadas com **Dagger Hilt**.
- **Camada de Persistência (Data Layer):** Armazenamento local robusto utilizando **Room Database**, DAOs e fluxos reativos.
- **Camada de Apresentação (UI Layer):** Telas declarativas e reativas com **Jetpack Compose**, gerenciadas por ViewModels orientadas a estado.
- **Visualização e Estatísticas:** Processamento e consolidação de dados para geração de gráficos analíticos e acompanhamento de gastos.

---

## 📱 Capturas de Tela

Confira as capturas de tela do aplicativo Expense Tracker:

| Tela Inicial | Adicionar Despesa | Estatísticas |
| :---: | :---: | :---: |
| Tela principal do aplicativo | Cadastro de despesas | Gráficos e resumo dos gastos |

> ℹ️ **Observação:** Adicione ou mantenha as imagens correspondentes na pasta `screenshots` do projeto para exibi-las nesta seção.

---

## 🚀 Como Começar

### Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- [Android Studio Bumblebee](https://developer.android.com/studio) ou versão posterior.
- Java 11 ou versão posterior.
- Android SDK com suporte à API 21 ou superior.

### Instalação

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/leomatiazzz/expense-tracker-kotlin.git
   ```

2. **Abra o projeto no Android Studio:**
   - Selecione a pasta do repositório que você acabou de clonar.

3. **Sincronize o projeto com o Gradle:**
   - Aguarde a conclusão da sincronização das dependências.

4. **Execute o aplicativo:**
   - Inicie o aplicativo em um emulador Android ou em um dispositivo físico compatível.

---

## 📖 Como Utilizar

### Adicionando uma despesa
1. Toque no botão para adicionar uma despesa.
2. Informe o valor da despesa.
3. Selecione uma categoria.
4. Adicione observações, se necessário.
5. Salve a despesa para registrá-la no aplicativo.

### Visualizando despesas
1. Acesse a tela de listagem de despesas.
2. Consulte as despesas registradas.
3. Se a funcionalidade estiver disponível na versão utilizada, selecione uma despesa para editá-la ou excluí-la.

### Acompanhando os gastos com estatísticas
1. Acesse a seção de estatísticas.
2. Consulte os gráficos e resumos apresentados.
3. Analise seus hábitos de consumo ao longo do tempo.

---

## 🤝 Contribuições

Contribuições são bem-vindas! Se você deseja ajudar a melhorar este projeto, pode:

- Relatar problemas na seção de **Issues**.
- Sugerir novas funcionalidades.
- Enviar melhorias por meio de **Pull Requests**.

> Antes de contribuir, confira as práticas e a estrutura existentes no projeto.

---

## 📬 Contato

Em caso de dúvidas ou sugestões, entre em contato com o desenvolvedor:

- **E-mail:** [leomatiasaraujo@gmail.com](mailto:leomatiasaraujo@gmail.com)
- **Repositório:** [Expense Tracker Kotlin](https://github.com/leomatiazzz/expense-tracker-kotlin)

---

<p align="center">
  Desenvolvido com Kotlin e tecnologias modernas para Android. ❤️
</p>
# MeuBolso — Controle de Gastos Pessoais 💰

[![Kotlin](https://img.shields.io/badge/Kotlin-2.0+-7F52FF?logo=kotlin&logoColor=white)](#)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Android-4285F4?logo=jetpackcompose&logoColor=white)](#)
[![Material 3](https://img.shields.io/badge/Material%203-Design-757575?logo=materialdesign&logoColor=white)](#)
[![Room](https://img.shields.io/badge/Room-Database-3DDC84?logo=android&logoColor=white)](#)

Aplicativo Android desenvolvido em **Kotlin** como projeto final do módulo de desenvolvimento Android. O **MeuBolso** permite cadastrar despesas pessoais, organizar os gastos por categoria e consultar os registros de maneira simples, intuitiva e prática.

---

## 📋 Informações Acadêmicas

- **Aluno:** Léo Matias Araújo
- **Matrícula:** Não se aplica
- **Data de entrega:** 09/10/2026
- **Projeto:** MeuBolso — Controle de Gastos Pessoais

---

## 🎯 Justificativa da Escolha do Tema

Escolhi desenvolver o **MeuBolso** porque o controle de gastos pessoais é uma necessidade presente no cotidiano e representa uma excelente oportunidade de aplicar os conhecimentos adquiridos durante o módulo de desenvolvimento Android.

O tema permite trabalhar com funcionalidades essenciais em aplicativos reais do mercado, tais como:
- Criação e validação de formulários;
- Organização e segmentação por categorias;
- Navegação fluida entre telas;
- Armazenamento local e persistência de dados.

Além de sua utilidade prática, o desenvolvimento do aplicativo possibilitou consolidar e aprofundar os conhecimentos em **Kotlin**, **Jetpack Compose**, persistência de dados com **Room** e organização de código estruturado na arquitetura **MVVM**.

---

## 📱 Descrição do Aplicativo

O **MeuBolso** é um aplicativo Android voltado para o controle financeiro pessoal. Seu principal objetivo é permitir que o usuário registre e consulte seus gastos de forma organizada, facilitando o acompanhamento financeiro diário.

### Funcionalidades
- ➕ **Cadastrar despesas:** informar a descrição, o valor e a categoria de cada gasto.
- 📋 **Visualizar despesas:** consultar a listagem completa de registros cadastrados.
- 🔍 **Consultar detalhes:** visualizar as informações completas de uma despesa específica.
- 🏷️ **Filtrar por categoria:** organizar a visualização dos gastos conforme a categoria selecionada.
- 🗑️ **Excluir despesas:** remover registros indesejados com confirmação de segurança.
- 📅 **Consultar datas e valores:** visualização dos lançamentos com datas e valores monetários devidamente formatados.

> **Persistência de Dados:**  
> Os dados são armazenados localmente no dispositivo utilizando o **Room Database** (abstração sobre SQLite). Dessa forma, os registros permanecem salvos com segurança mesmo após o fechamento e a reabertura do aplicativo.

---

## 🛠️ Tecnologias Utilizadas

- **[Kotlin](https://kotlinlang.org/):** Linguagem de programação moderna e concisa utilizada no desenvolvimento da aplicação.
- **[Jetpack Compose](https://developer.android.com/jetpack/compose):** Toolkit declarativo moderno para construção de interfaces de usuário nativas.
- **Material 3:** Componentes e padrões visuais modernos para a interface Android.
- **Navigation Compose:** Gerenciamento declarativo da navegação entre telas.
- **Room Database:** Biblioteca de persistência local baseada em SQLite.
- **Kotlin Coroutines & Flow / StateFlow:** Recursos para operações assíncronas e observação reativa de dados.
- **ViewModel:** Gerenciamento do estado e dos dados utilizados pela interface.
- **Repository & DAO:** Padrão arquitetural para abstração do acesso a dados e operações no banco.

---

## 🏗️ Arquitetura e Organização do Projeto

O projeto adota a arquitetura **MVVM (Model-View-ViewModel)** com separação de responsabilidades para facilitar a organização, a legibilidade e a manutenção do código.

```
┌──────────────────────────────────────┐
│           UI (Jetpack Compose)       │
└──────────────────┬───────────────────┘
                   │ Observa StateFlow / Dispara Ações
┌──────────────────▼───────────────────┐
│              ViewModel               │
└──────────────────┬───────────────────┘
                   │ Solicita / Manipula Dados
┌──────────────────▼───────────────────┐
│             Repository               │
└──────────────────┬───────────────────┘
                   │ Executa Operações
┌──────────────────▼───────────────────┐
│        DAO (Data Access Object)      │
└──────────────────┬───────────────────┘
                   │ Persistência Local
┌──────────────────▼───────────────────┐
│             Room Database            │
└──────────────────────────────────────┘
```

### Principais Responsabilidades
- **Model:** Representa os modelos de dados utilizados pela aplicação, incluindo a entidade de despesas.
- **DAO (Data Access Object):** Define as operações de consulta e manipulação dos registros no banco de dados.
- **Repository:** Intermedeia o acesso aos dados e centraliza as operações de persistência.
- **ViewModel:** Gerencia o estado da aplicação e disponibiliza os dados e as ações necessárias para a interface.
- **Interface (UI):** Apresenta as telas e recebe as interações do usuário por meio do Jetpack Compose.
- **Room Database:** Gerencia o armazenamento local SQLite das despesas.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- **Android Studio** instalado.
- **Android SDK** compatível com a configuração do projeto.
- **JDK** e ferramentas de compilação compatíveis com as versões configuradas no Gradle.
- **Emulador Android** ou dispositivo físico com **Depuração USB** habilitada.

### Instalação e Execução

1. **Clone este repositório:**
   ```bash
   git clone https://github.com/leomatiazzz/expense-tracker-kotlin.git
   ```

2. **Abra o projeto no Android Studio:**
   - Inicie o Android Studio.
   - Selecione a opção para abrir um projeto existente (**Open**) e escolha a pasta clonada.

3. **Sincronize as dependências:**
   - Aguarde a sincronização do Gradle e o download das dependências.

4. **Execute o aplicativo:**
   - Selecione um emulador Android ou conecte um dispositivo físico compatível.
   - Execute o aplicativo utilizando o botão **Run** (`▶`) ou o atalho `Shift + F10`.

> [!TIP]
> Caso ocorram erros de compilação ou sincronização, verifique as mensagens exibidas na janela **Build** / **Sync** do Android Studio.

---

## 🧪 Testes e Validação

- O projeto inclui **testes unitários** relacionados às regras de validação e formatação de valores monetários.
- A compilação e os testes podem ser executados no ambiente de desenvolvimento para verificar o funcionamento da versão atual do código:
  ```bash
  ./gradlew test
  ```
- Também é recomendado testar manualmente o fluxo completo no emulador ou dispositivo físico:
  - Cadastro de despesas
  - Listagem e detalhes
  - Filtragem por categoria
  - Exclusão com confirmação
  - Persistência dos dados após fechar e reabrir o app

---

## 📝 Observações

- O armazenamento das despesas é local, utilizando Room Database (não requer conexão com a internet).
- O aplicativo foi desenvolvido para fins acadêmicos e de aprendizagem.
- As funcionalidades descritas correspondem ao escopo do projeto e estão preparadas para receber melhorias em versões futuras.
- A execução e a validação devem ser realizadas com base no código presente neste repositório.

---

## 👨‍💻 Autor

**Léo Matias Araújo**

- 🐙 **GitHub:** [@leomatiazzz](https://github.com/leomatiazzz)
- 📦 **Repositório do projeto:** [expense-tracker-kotlin](https://github.com/leomatiazzz/expense-tracker-kotlin)

---

<p align="center">
  Desenvolvido com <b>Kotlin</b>, <b>Jetpack Compose</b> e tecnologias modernas para Android. 💚
</p>

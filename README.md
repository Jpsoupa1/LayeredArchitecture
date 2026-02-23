# Sistema CRUD de Produtos - Arquitetura em Camadas

## 📚 Objetivo Educacional

Este é um **projeto educacional** desenvolvido para que os alunos compreendam o funcionamento de uma **arquitetura em camadas** (layered architecture), um padrão fundamental no desenvolvimento de aplicações Java.

Através deste projeto, você aprenderá:
- Como separar responsabilidades em diferentes camadas
- A importância da abstração através de interfaces
- O padrão de design Repository
- Boas práticas de organização de código
- Como implementar um CRUD completo

## 🏗️ Estrutura da Arquitetura em Camadas

A aplicação é dividida em três camadas principais:

```
┌─────────────────────────────────────┐
│     CAMADA DE APRESENTAÇÃO          │
│     (ProdutoController)             │
│     - Recebe requisições            │
│     - Controla o fluxo da aplicação │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│     CAMADA DE NEGÓCIOS              │
│     (ProdutoService)                │
│     - Lógica de negócio             │
│     - Regras de validação           │
│     - Processamento de dados        │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│     CAMADA DE PERSISTÊNCIA          │
│     (ProdutoRepository)             │
│     - Acesso aos dados              │
│     - Operações no banco de dados   │
└─────────────────────────────────────┘
```

## 📁 Estrutura de Arquivos

```
arquitetura_camadas/
├── Produto.java                 # Entidade (Model)
├── ProdutoController.java       # Camada de Apresentação
├── ProdutoService.java          # Interface - Camada de Negócios
├── ProdutoRepository.java       # Interface - Camada de Persistência
├── Main.java                    # Ponto de entrada da aplicação
└── README.md                    # Este arquivo
```

## 🔍 Descrição das Camadas

### 1️⃣ Camada de Apresentação (Controller)
- **Arquivo**: `ProdutoController.java`
- **Responsabilidade**: Controlar as requisições do usuário
- **Métodos**:
  - `cadastrar()` - Cria um novo produto
  - `buscarPorId()` - Busca produto por ID
  - `buscarPorNome()` - Busca produtos por nome
  - `listarTodos()` - Lista todos os produtos
  - `alterar()` - Atualiza um produto
  - `remover()` - Deleta um produto

### 2️⃣ Camada de Negócios (Service)
- **Arquivo**: `ProdutoService.java` (interface)
- **Responsabilidade**: Implementar a lógica de negócio
- **Características**:
  - Validações de dados
  - Regras de negócio
  - Orquestração entre controller e repository
  - Métodos similares ao controller

### 3️⃣ Camada de Persistência (Repository)
- **Arquivo**: `ProdutoRepository.java` (interface)
- **Responsabilidade**: Gerenciar o acesso aos dados
- **Operações CRUD**:
  - `salvar()` - Insere um novo produto
  - `buscarPorId()` - Recupera produto por ID
  - `buscarPorNome()` - Pesquisa por nome
  - `listarTodos()` - Retorna todos os produtos
  - `atualizar()` - Modifica um produto existente
  - `deletar()` - Remove um produto

### 4️⃣ Entidade (Model)
- **Arquivo**: `Produto.java`
- **Atributos**:
  - `id` - Identificador único
  - `nome` - Nome do produto
  - `descricao` - Descrição detalhada
  - `preco` - Valor do produto
  - `quantidade` - Quantidade em estoque

## 🚀 Próximos Passos para Implementação

1. **Implementar a interface `ProdutoService`** em uma classe concreta
   - Adicionar lógicas de validação
   - Implementar as operações CRUD chamando o repository

2. **Implementar a interface `ProdutoRepository`** em uma classe concreta
   - Utilizar uma estrutura de dados (List, HashMap, etc.)
   - Implementar as operações de persistência

3. **Completar o `ProdutoController`**
   - Chamar os métodos do service
   - Exibir resultados ao usuário

4. **Desenvolver a `Main`**
   - Criar menu interativo
   - Permitir entrada do usuário
   - Testar todas as funcionalidades

## 💡 Benefícios da Arquitetura em Camadas

✅ **Separação de Responsabilidades** - Cada camada tem um propósito específico  
✅ **Facilidade de Manutenção** - Fácil localizar e corrigir problemas  
✅ **Reusabilidade** - Componentes podem ser reutilizados em outros contextos  
✅ **Testabilidade** - Cada camada pode ser testada independentemente  
✅ **Escalabilidade** - Novas funcionalidades se adaptam facilmente  
✅ **Independência de Tecnologia** - Trocar implementações sem afetar outras camadas  

## 📚 Referências

- [Design Patterns - Layered Architecture](https://refactoring.guru/design-patterns)
- [Repository Pattern](https://refactoring.guru/design-patterns/repository)
- [SOLID Principles](https://en.wikipedia.org/wiki/SOLID)

---

**Este é um projeto de aprendizado. Sinta-se livre para experimentar, modificar e evoluir o código!** 🎓

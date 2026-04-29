# 🏟️ Arena de Pernambuco

Aplicação web desenvolvida em Java com Spring Boot para melhorar a ocupação e a divulgação da Arena Pernambuco. O sistema atua entre a administração do equipamento público e a população, combatendo a desaproveitamento do espaço através de uma vitrine digital de eventos e ferramentas de gestão de dados.

## 🎯 Objetivo do Projeto

Facilitar a comunicação entre interessados e a administração da Arena, incentivando o uso do espaço para diversos tipos de eventos, além de fornecer métricas estatísticas para auxiliar na tomada de decisões governamentais, relacionados ao uso do espaço.

## 📦 Escopo

- Desenvolver aplicação web em Java (Spring Boot)  
- Definir arquitetura do sistema (MVP)  
- Modelar domínio com DDD  
- Implementar funcionalidades principais da aplicação  
- Configurar infraestrutura de comunicação (rede, topologia e serviços)  
- Implementar pipeline de CI/CD  
- Realizar deploy em ambiente de nuvem  
- Aplicar threads para otimização de processos  
- Definir e coletar métricas do sistema  
- Estruturar e armazenar dados  
- Realizar análise estatística dos dados  
- Criar dashboards de monitoramento e análise  
- Validar desempenho, conectividade e disponibilidade

## 🧩 Modelagem de Domínio (DDD)

O sistema Arena Pernambuco possui como domínio principal a gestão de eventos e ocupação da arena, com foco na administração eficiente do espaço público, divulgação de eventos e apoio à tomada de decisão por meio de indicadores estratégicos.

A modelagem foi estruturada com base em DDD (Domain-Driven Design), permitindo maior organização das regras de negócio, escalabilidade da aplicação e separação clara entre responsabilidades.

### Domínio Principal

### Gestão de Eventos e Ocupação da Arena

Responsável por:

- cadastro e publicação de eventos  
- solicitação e controle de reservas  
- gestão da agenda da arena  
- vitrine pública de eventos  
- geração de indicadores administrativos  
- suporte à gestão institucional

### Principais Subdomínios

#### Gestão de Eventos

Responsável pelo cadastro, edição, categorizção e publicação dos eventos realizados na arena.

#### Sistema de Reservas

Responsável pela solicitação, aprovação e controle de uso do espaço físico, evitando conflitos de agenda.

#### Usuários e Perfis

Responsável pela autenticação, autorização e controle de acesso de administradores, organizadores e usuários externos.

#### Indicadores e Relatórios

Responsável pela geração de métricas como taxa de ocupação, reservas confirmadas, cancelamentos e relatórios gerenciais.

### Principais Entidades

- Usuário  
- Evento  
- Reserva  
- Agenda da Arena  
- Categoria de Evento  
- Indicadores  
- Auditoria

### Relacionamentos Principais

- Um usuário pode criar vários eventos  
- Um usuário pode realizar várias reservas  
- Cada reserva está vinculada a um evento  
- Cada evento pertence a uma categoria  
- Cada evento ocupa um espaço na agenda da arena  
- O sistema gera indicadores para apoio à gestão  
- Todas as ações relevantes possuem rastreabilidade por auditoria

Essa estrutura permite a implementação de uma arquitetura robusta em Spring Boot com padrão MVC, integração com banco de dados MySQL e aderência às exigências de segurança e conformidade da administração pública.

## ⚙️ Arquitetura Inicial do Sistema (MVP)

A versão inicial do sistema foi definida com foco em funcionalidade, escalabilidade e facilidade de evolução, garantindo uma base sólida para futuras integrações e expansão da plataforma.

O MVP (Minimum Viable Product) contempla os principais fluxos operacionais da Arena Pernambuco, permitindo a gestão eficiente de eventos, reservas e indicadores administrativos.

Os principais componentes contemplados nesta fase são:

- vitrine digital de eventos
- sistema de solicitação e controle de reservas
- painel administrativo para gestão interna
- módulo de indicadores e relatórios gerenciais
- controle de usuários e permissões
- auditoria e rastreabilidade de operações

A estrutura foi planejada para suportar crescimento modular, integração com serviços governamentais e conformidade com as exigências de segurança da informação e LGPD.

## 🛠️ Tecnologias Utilizadas

### ☕ Back-end
- Java
- Spring Boot
- Spring Data JPA

### 🎨 Front-end
- HTML
- CSS
- Thymeleaf

### 🗄️ Banco de Dados
- MySQL (via Docker) 🐳

## 🏗️ Planejamento de Infraestrutura

### Objetivos da Infraestrutura
- Disponibilidade: garantir que a vitrine de eventos esteja sempre online para consulta da população.
- Integridade: assegurar que os dados de reservas e métricas governamentais sejam armazenados de forma segura e consistente.
- Escalabilidade: capacidade de suportar picos de acesso durante o anúncio de grandes eventos.

### Restrições Técnicas e de Negócio
- Custo: priorização de tecnologias Open Source e infraestrutura de baixo custo.
- Conformidade: o tratamento de dados deve seguir as diretrizes da LGPD (Lei Geral de Proteção de Dados).
- Ambiente: a aplicação deve ser executada obrigatoriamente em containers para garantir portabilidade entre servidores governamentais.

## 📈 Indicadores de Monitoramento

### Indicadores de Uso da Plataforma

- Quantidade de acessos ao sistema  
- Número de usuários cadastrados  
- Taxa de visualização de eventos  

Objetivo: medir o alcance da vitrine digital e o interesse da população pelos eventos divulgados.

### Indicadores de Gestão de Eventos

- Quantidade de eventos cadastrados  
- Taxa de ocupação da Arena  
- Taxxa de reservas confirmadas  
- Taxa de cancelamento  

Fórmula da Taxa de Ocupação:

Taxa de Ocupação = (Eventos Realizados / Capacidade de Agenda Disponível) × 100

Objetivo: avaliar o nível de aproveitamento do espaço público e apoiar decisões estratégicas da administração.

### Indicadores Administrativos

- Tempo médio de resposta às solicitações  
- Demandas pendentes  
- Relatórios gerenciais emitidos  

Objetivo: melhorar a eficiência da gestão pública no atendimento e no controle das reservas.

### Indicadores Técnicos

- Disponibilidade do sistema (Uptime)  
- Tempo médio de carregamento  
- Número de falhas registradas  

Fórmula do Uptime:

Uptime = (Tempo de Funcionamento / Tempo Total) × 100

Objetivo: garantir estabilidade, desempenho e acesso contínuo à plataforma.

### Indicadores de Segurança e Conformidade

- Incidentes de segurança  
- Controle de conformidade com a LGPD  

Objetivo: assegurar proteção de dados e conformidade legal no ambiente governamental.

## 🌐 Requisitos Técnicos de Rede

### Desempenho

#### Requisito de Negócio
Garantir acesso rápido e contínuo da população à vitrine digital de eventos, especialmente em períodos de grande divulgação.

#### Requisito Técnico
- Servidor com capacidade para múltiplas conexões simultâneas  
- Baixa latência entre aplicação e banco de dados  
- Monitoramento de CPU, memória e tráfego de rede  
- Utilização de containers Docker para melhor gerenciamento de recursos  

Objetivo: reduzir o tempo de resposta da aplicação e melhorar a experiência do usuário.

### Segurança

#### Requisito de Negócio
Proteger dados de usuários, reservas e informações administrativas, garantindo conformidade com a LGPD.

#### Requisito Técnico
- Implementação de HTTPS com SSL/TLS  
- Controle de acesso por autenticação e perfis  
- Firewall para restrição de acessos indevidos  
- Backup periódico do banco de dados MySQL  
- Registro de logs e auditoria de acessos  

Objetivo: garantir proteção da informação e conformidade legal.

### Disponibilidade

#### Requisito de Negócio
Manter a plataforma acessível continuamente para consultas públicas e gestão administrativa.

#### Requisito Técnico
- Hospedagem em ambiente estável  
- Monitoramento contínuo de uptime  
- Backup automatizado e recuperação rápida  
- Uso de containers para rápida restauração em falhas  

Objetivo: garantir continuidade operacional e reduzir indisponibilidades.

### Escalabilidade

#### Requisito de Negócio
Permitir crescimento do sistema conforme aumento da demanda e futuras integrações governamentais.

#### Requisito Técnico
- Arquitetura compatível com expansão horizontal  
- Docker Compose para facilitar replicação  
- Banco de dados preparado para aumento de volume  
- Estrutura modular com Spring Boot e padrão MVC  

Objetivo: permitir crescimento sem necessidade de reestruturação completa.

### Conformidade Institucional

#### Requisito de Negócio
Atender às exigências da administração pública e compatibilidade com servidores governamentais.

#### Requisito Técnico
- Priorização de tecnologias Open Source  
- Portabilidade entre ambientes com Docker  
- Compatibilidade com infraestrutura institucional  
- Padronização de implantação e versionamento  

Objetivo: reduzir custos e garantir aderência às políticas internas de TI.

## 🖧 Diagrama de Comunicação e Topologia de Rede

A topologia adotada foi do tipo estrela hierárquica, com separação entre acesso externo e rede interna. O primeiro roteador faz a conexão com a internet, o segundo atua como firewall, e o switch central distribui o acesso aos servidores de aplicação, banco de dados e backup, garantindo segurança, disponibilidade e escalabilidade.

<img width="511" height="424" alt="image" src="https://github.com/user-attachments/assets/04038325-54bc-429b-bb3a-a56a0d60c3a8" />

## 📊 Funcionalidades

- Gestaõ de eventos  
- Vitrini de eventos  
- Sistema de reservas 
- Painel de dados 

## 🚀 Como Executar o Projeto

Siga as instruções abaixo para configurar o ambiente e rodar a aplicação localmente.

### Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:
* Git
* Docker
* Java 17 ou superior

---

### Passo a Passo

1. **Clone o repositório e acesse a pasta:**
```bash
git clone https://github.com/SergioGSF/programa-cultural-digital
cd programa-cultural-digital/arenapernambuco
```

2. **Suba os containers do Docker:**
```bash
docker-compose up -d
```

3. **Crie o banco de dados:**
```bash
docker exec -it mysql_arena mysql -u root -p1234 -e "CREATE DATABASE IF NOT EXISTS arena_pernambuco;"
```

4. **Construa o projeto:**
```bash
./mvnw clean package
```

5. **Execute a aplicação:**
```bash
./mvnw spring-boot:run
```

---

### Acesso

Após a inicialização, a aplicação estará disponível em:
[http://localhost:8080](http://localhost:8080)

## 🧱 Estrutura do Projeto

O projeto segue uma arquitetura baseada no padrão MVC:

- Model: entidades e estrutura de dados do sistema  
- Repository: camada de acesso ao banco de dados com Spring Data JPA  
- Service: regras de negócio da aplicação  
- Controller: controle das requisições HTTP  
- Templates: páginas HTML renderizadas com Thymeleaf  

## 🔮 Possíveis Melhorias Futuras
- Integração com APIs de geolocalização e mapas 
- Sistema de notificação automática  
- Integração odiciais com sistemas governamentais
- Validade jurídica de operações
- Automações avançadas 

## 👥 Equipe

- Allana Sílvia Gadêlha de Carvalho Souza  
- Carlos Henrique Gonçalves da Silva  
- Claudemir Pereira de Araujo Filho  
- Everton Nunes Batista  
- Samara Mendonça Nunes  
- Sergio Gonçalves da Silva Filho

## 📁 Entrega 1
- Histórias de usuário:
https://docs.google.com/document/d/1lhORnMbUCOVKTaVsYzWjMuSxe1MJcixIdLyDGVHj028/edit?usp=sharing
- Screencast do Figma:
https://youtu.be/ahp9xVqzgTo
- Trello:
https://trello.com/b/vi5lSu6D/poo-projeto-arena-cultural

## 📁 Entrega 2
- Issues/bug tracker: 
https://github.com/SergioGSF/programa-cultural-digital/issues
<img width="1230" height="249" alt="image" src="https://github.com/user-attachments/assets/7818d212-a18f-4777-9078-fa55132fbc60" />
<img width="1233" height="182" alt="image" src="https://github.com/user-attachments/assets/f920d4e5-52d6-4f9f-90be-d77c041cb03d" />

- Screencast 2 histórias: 
https://youtu.be/QybrQOebOSA

## 📁 Entrega 3
- Issues/bug tracker: 
https://github.com/SergioGSF/programa-cultural-digital/issues
<img width="1234" height="310" alt="image" src="https://github.com/user-attachments/assets/1fa53591-cb23-41d7-bae4-8ebad4384291" />
<img width="920" height="585" alt="image" src="https://github.com/user-attachments/assets/6eec91a4-cff8-4940-a424-d662b88a142e" />

- Screencast: 
https://youtu.be/wE20pIKdeRU

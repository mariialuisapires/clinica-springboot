API Clínica Médica - Spring Boot

Este projeto é uma API REST desenvolvida em **Java com Spring Boot**, simulando o gerenciamento de uma clínica médica. Ele permite o cadastro, atualização, listagem e remoção de **pacientes**, **médicos**, **remédios** e **consultas**.

---

Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (ou outro)
- Maven
- Postman (para testes)
- Git + GitHub

---

Estrutura das Entidades

 Patient
- `id_patient` (Integer)
- `name` (String)
- `cpf` (String)
- `cellphone` (String)
- `email` (String)
- `address` (String)

 Doctor
- `id_doctor` (Integer)
- `name` (String)
- `cpf` (String)
- `cellphone` (String)
- `email` (String)
- `specialty` (String)
Remedy
- `id_remedy` (Integer)
- `type` (String)
- `price` (Double)

Consultation
- `id_consultation` (Integer)
- `remedy` (Remedy)
- `doctor` (Doctor)
- `patient` (Patient)
- `finalPrice` (Double)



Testes com Postman
Use o Postman para testar os endpoints.
Exemplos de JSON para envio estão documentados na aba "Documentation" de cada request na Collection Postman.



Observações
O projeto usa DTOs para comunicação segura entre frontend e backend.

O relacionamento entre as entidades é gerenciado por JPA/Hibernate, com mapeamentos @OneToMany, @ManyToOne, etc.

Toda lógica está separada em camadas: controller, service, repository e model.


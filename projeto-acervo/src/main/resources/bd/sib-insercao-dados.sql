INSERT INTO livro (isbn, titulo_livro, autor, editora, data_publicacao, descricao, img, total, emprestado, disponivel)
VALUES 
  ('9788543109312', 'O lado bom do lado ruim', 'Daniel Martins de Barros', 'Sextante', '2020-02-14', 'COMO A CIÊNCIA ENSINA A USAR A TRISTEZA, O MEDO, A RAIVA E OUTRAS EMOÇÕES NEGATIVAS A SEU FAVOR. Do mesmo autor do livro Pílulas de bem-estar. Aprendemos desde cedo que o correto é estar feliz o tempo todo, e com isso acabamos desvalorizando as emoções negativas. Queremos negá-las, sufocá-las, eliminá-las do nosso caminho. Neste livro, o psiquiatra e professor Daniel Martins de Barros nos mostra que as emoções desagradáveis não são sons incômodos que devem ser silenciados. Em vez disso, são alertas preciosos que nos chamam atenção para algo mais profundo que não vai bem na nossa vida. Com leveza e uma linguagem simples e acessível, o autor conta vários casos pessoais e apresenta estudos científicos para nos ajudar a compreender esses avisos e a desenvolver mecanismos para atuar na origem dos nossos problemas. Dessa forma, poderemos encontrar o equilíbrio entre as emoções, desenvolver nosso autoconhecimento e ter uma existência mais plena.', NULL, 10, 0, 10),
  ('9786555351835', 'Verdades difíceis de engolir', 'Samantha Silvany ', 'Outro Planeta', '2020-10-15', '"Amor é morar em um peito que nos cabe por inteiro. Se a gente precisa forçar a entrada ou se espremer para servir, é hora de nos mudarmos." O escritor Dan pensava estar vivendo um verdadeiro romance clichê com seu amor de infância, pelo menos até conhecer Sofia, uma mulher que o faz sentir coisas que nunca sentiu antes. Sofia, uma mulher empoderada e decidida, mas azarada no amor, achava ter encontrado seu par perfeito, até descobrir que seu príncipe encantado era o mesmo de outra pessoa. Já Alicia está convencida de que encontrou o grande amor e que nada e ninguém irão impedi-la de seguir ao altar e ter seu tão sonhado "felizes para sempre". Mesmo que precise passar por cima de si mesma para isso. Mesmo que tenha que esmagar seu amor-próprio para provar para si e para os outros que aquele homem é a metade que lhe falta. Mas será que as pessoas realmente são incompletas e precisam de outra metade para encontrar a felicidade? O preço para viver um grande amor pode ser a própria dignidade? A sororidade existe mesmo ou é só uma palavra bonita que decidiram acrescentar no dicionário? Sofia tem algumas respostas para essas perguntas, mas Alicia tem outras bem diferentes...', NULL, 15, 0, 15),
  ('9786558380634', 'A Biblioteca da Meia-Noite', 'Matt Haig', 'Bertrand', '2021-09-20', 'Aos 35 anos, Nora Seed é uma mulher cheia de talentos e poucas conquistas. Arrependida das escolhas que fez no passado, ela vive se perguntando o que poderia ter acontecido caso tivesse vivido de maneira diferente. Após ser demitida e seu gato ser atropelado, Nora vê pouco sentido em sua existência e decide colocar um ponto final em tudo. Porém, quando se vê na Biblioteca da Meia-Noite, Nora ganha uma oportunidade única de viver todas as vidas que poderia ter vivido. Neste lugar entre a vida e a morte, e graças à ajuda de uma velha amiga, Nora pode, finalmente, se mudar para a Austrália, reatar relacionamentos antigos – ou começar outros –, ser uma estrela do rock, uma glaciologista, uma nadadora olímpica... enfim, as opções são infinitas. Mas será que alguma dessas outras vidas é realmente melhor do que a que ela já tem? Em A Biblioteca da Meia-Noite, Nora Seed se vê exatamente na situação pela qual todos gostaríamos de poder passar: voltar no tempo e desfazer algo de que nos arrependemos. Diante dessa possibilidade, Nora faz um mergulho interior viajando pelos livros da Biblioteca da Meia-Noite até entender o que é verdadeiramente importante na vida e o que faz, de fato, com que ela valha a pena ser vivida.', NULL, 20, 0, 20),
  ('9789722106993', 'Vidas secas', 'Graciliano Ramos', 'Caminho', '2008-04-11', 'Vidas Secas é um influente e importante romance do escritor brasileiro Graciliano Ramos, escrito entre 1937 e 1938, publicado originalmente em 38 pela antológica Livraria José Olympio Editora, hoje editado pela Editora Record, e considerado por muitos como a maior obra do autor.', '', 7, 0, 7),
  ('9786557821879', 'Grande sertão: veredas', 'João Guimarães Rosa', 'Companhia de Bolso', '2021-04-19', 'Edição de bolso de uma das principais obras-primas da língua portuguesa. "O correr da vida embrulha tudo, a vida é assim: esquenta e esfria, aperta e daí afrouxa, sossega e depois desinquieta. O que ela quer da gente é coragem." Publicado originalmente em 1956, Grande sertão: veredas é uma das obras mais apaixonantes da literatura brasileira. Ao narrar o mundo através dos olhos de Riobaldo, Guimarães Rosa constrói um romance fascinante, que mescla sofrimento, luta, alegria, violência, amor e morte em uma prosa extremamente inventiva. Neste clássico arrebatador, as paisagens percorridas pelos jagunços ganham uma dimensão universal e profundamente humana. "Sertão: é dentro da gente." Esta edição, de bolso, conta com posfácio de Davi Arrigucci Jr., cronologia do autor e sugestões de leitura.', NULL, 6, 0, 6);
  
INSERT INTO leitor (nome_leitor, cpf_leitor, email_leitor, emprestimo_leitor)
VALUES 
  ('Helder', '12345678901', 'hbsj@discente.ifpe.edu.br', 0),
  ('Ciclano da Silva', '98765432101', 'ciclano@example.com', 0),
  ('Beltrano Pereira', '11122334455', 'beltrano@example.com', 0),
  ('Brayan', '22222222222', 'bvcl@discente.ifpe.edu.br', 0),
  ('Kaio', '33333333333', 'kvsb@discente.ifpe.edu.br', 0);
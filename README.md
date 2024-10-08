# Hangman Game
```bash
   _______
  |/      |
  |       |
  |       |
  |       |
  |      (_)
  |     \-|-/
  |      / \
  |
 _|_
|   |________
|____________|

_в__________в_____
```

## Описание
Добро пожаловать в игру "Виселица"! Это классическая текстовая игра, в которой игроку нужно угадывать слово по буквам. В этой версии игры добавлен ряд улучшений, таких как возможность выбора категории слов, различные уровни сложности и система подсказок.

## Особенности
- **Паттерн состояние**: Игра реализована через паттерн состояние, это позволяет легко описывать и изменять логику поведения на каждом экране.
- **Выбор категории слов**: Игрок может выбрать категорию слов перед началом игры.
- **Уровни сложности**: Игра поддерживает несколько уровней сложности, что позволяет сделать её интересной как для новичков, так и для опытных игроков.
- **Подсказки**: Каждое слово сопровождается подсказкой, которая поможет игроку в случае затруднений.
- **Графика виселицы**: В зависимости от количества ошибок виселица постепенно "растет", отображая стадии казни.
- **Учёт уже введённых букв**: Введённые ранее буквы не уменьшают количество жизней при повторном вводе.

## Установка и запуск
### Требования
Для запуска игры необходима установка следующих зависимостей:
- Java 22+
- Maven (для сборки проекта)

### Установка
1. Склонируйте репозиторий с игрой:
    ```bash
    git clone https://github.com/m-fedosov/hangman_game.git
    ```
2. Перейдите в директорию проекта:
    ```bash
    cd hangman_game
    ```
3. Соберите проект с помощью Maven:
    ```bash
    mvn clean install
    ```

```bash
                                 ......             __  _  ____  __ __  ______   ___   __ 
                         ...:::::^^^^^~~^7?:       |  l/ ]|    \|  T  T|      T /   \ |  T
                       ...:::^^^~^~~^^^^^~7!.      |  ' / |  o  )  |  ||      |Y     Y|  |
                      ....::^^^^~~~~~!~~^~~~!.     |    \ |   _/|  ~  |l_j  l_j|  O  ||__j
                     ...::~~~~~~~!~~~~~^~~~~~!.    |     Y|  |  l___, |  |  |  |     | __ 
                     ...:::^^~!!~!!~~~^^~~~!!!^    |  .  ||  |  |     !  |  |  l     !|  T
                     ...:::^^~~~!!77!!!!!!777!~.   l__j\_jl__j  l____/   l__j   \___/ l__j
                    ....:::^^~~~!!??77?JJ555J7!:                                                    
                   .:.:.:::^~~~~!!77777?JY55Y?~                                                     
                  ^^::::::::^~!?J!~~~!7?Y555Y^                                                      
                  :^!:::::^^^~!J55?^~JPPPPPY?                                                       
                   ^~:::::^~~~!77!~^~YPP5555!                              ..                       
                    .::::::^^~~~!~:^!JYYYYYJ                              .!?.                      
                      :::::^^^~77!~^~?Y!~?J^                              ^7J.                      
                      .:::::::^^~!7??YY^^77                              .~!7~...                   
                       :::::::^^!5PGG5J~:7?.                             :^^^?JJJ?:                 
                      .:^^:::^~~~7?JJYY~:!7^::::                        .::^^!?JJJJJ^               
                      ::^^^^^^^~!7?YYJ7::^^^^~!7~::^:::::::::.          .:^^~~???JYYJ.              
                   ..::^^^~~~~~~!!7???~:~~~~~~~!?~^^^^^:^^::^^^:        :^^~~!?J?JJY57              
              ..^7?~~^^^~~!!7?JJJJJJJ?^^~~!!~!!7?~^^^^^^^^::^~^^^.      :~!!!77?77?J57              
            .....:^^~!~~!!!!7JYYJ?7!~^^:~~!!!!!??~~~^^^^^^^^^~~^~~^.     ^~~!!!!!!7?^               
  ..::::::::::::::::::^^^^~J5P#B7~~~~^^^^!!7!77?~~~^^^^^^^^~^~~~~!!!:    .~~~~!7??!.                
::^^:^^^^^^^^^^^^::::::::::^7YJ?!~~~~^^^~!!77!~~^~~^^~^^^^:^~!!~!~~!!!. .!!~~!?Y55                  
:::^^^^^^^~^^~~~~^^^^^^^^^^^^^^^^~~~~~~~!!7JJ~~~^~~~~~~~^^^^~!!!!~~!!!!~~7Y?77JY5Y^                 
^^^^^^^^^^^~~~~!!~~~~~~~~^^~!~~^~7~~!!!!7??7!!~!!!!!!~~~~~^^~777!!~!!!!77!!?7777??J?                
^^^^^^^~~~~~~~~~~!!!~~~!!~~!7!~:^!!!!!7JJ7!~!!!!!!!!!!~~~!!!!7?77!!!!!!777^~!!!7?JJ7                
^^^^^~~~~~!!!!!!~~!!!!!!!!!!!~^^^^~!7?Y5J~~~~~~!!!!!!!!!777777?J?77!!!!777~~!!77?JJJ.               
^~~~~~~~~~!!777!7!~!!77!!!!!^^^^^^^^~7JJ7!~~~!!!!!!!!!77777777?JJ?77!77777~!!77?JJYY!       
```

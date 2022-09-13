# Unit Testing

### Seven Testing Principles

1. Testing is context dependent - тестването зависи от контекста
- Testing is done differently in different contexts
- Example : Safety-critical software is tested differently from an e-commerce site

2. Exhaustive testing is impossible - да тестваме всичко е невъзможно, не можем да приемем тестовете
   за 100% сигурно,че всичко работи и нямаме никакъв бъг.
- All combinations of inputs and preconditions are usually almost infinite number
- Testing everything is not feasible except for trivial cases(add(int, int))
- Risk analysis and priorities should be used to focus testing efforts

3.Defecting clustering
- Testing effort shall be focused proportionally
    * To the expected and later observed defect density of modules
- A small number of modules usually contains most of the defects discovered
    * Responsible for most of the operational failures

4. Early testing is always preferred - Колкото по-рано тестваме, толкова по-евтино е

5.Pesticide paradox - Когато повтаряме тестовете отново и отнове, може да не бъдат толкова ефективни
6. Testing shows presence of defects
7. Absence of errors fallacy - Когато система работи, не означава,че на 100% нямаме грешки
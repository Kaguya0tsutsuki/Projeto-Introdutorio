export default class Salva{
    #tarefaList;

    constructor(){
        this.#tarefaList = [];
    }

    adicionarTarefa(tarefa){
        this.#tarefaList.push(tarefa);
    }

    get tarefaList(){
        return this.#tarefaList;
    }

    limpar(){
        this.#tarefaList.splice(0, this.#tarefaList.length);
    }
}
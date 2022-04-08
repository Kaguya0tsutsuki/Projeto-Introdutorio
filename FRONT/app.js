import Salva from "./salva.js";

const nomeTarefa = document.querySelector("#nomeTarefa");
const descricaoTarefa = document.querySelector("#descricaoTarefa");
const dataTerminoTarefa = document.querySelector("#dataTerminoTarefa");
const prioridadeTarefa = document.querySelector("#prioridadeTarefa");
const categoriaTarefa = document.querySelector("#categoriaTarefa");
const statusTarefa = document.querySelector("#statusTarefa");

const listaTarefa = document.querySelector(".lista_tarefa");

const botaoCriar = document.querySelector("#criar");
const botaoLimpar = document.querySelector("#limpar");
const botaoListar = document.querySelector("#listar");
const botaoListarTarefa = document.querySelector("#listar_uma_tarefa");
const botaoModificar = document.querySelector("#modificar");

const salva = new Salva();

botaoCriar.addEventListener('click', () => criarTarefa());
botaoLimpar.addEventListener('click', () => limparTarefa());
botaoListar.addEventListener('click', () => listarTarefa());
botaoListarTarefa.addEventListener('click', () => listarUmaTarefa());
botaoModificar.addEventListener('click', () => modificarTarefa());

let tarefa = [];

function criarTarefa(){

    let x = 0;

    if(nomeTarefa.value === ""){
        descricaoTarefa.value = "";
        alert("Nome não Informado!");
        return ;
    }

    while(x < tarefa.length){
        
        if(nomeTarefa.value === tarefa[x][0]){
            nomeTarefa.value = "";
            alert("Nome Inválido!");
            x = 0;
            return;
        }
        x++;      
    }

    if(descricaoTarefa.value === ""){
        descricaoTarefa.value = "";
        alert("Descrição não Informada!");
        return ;
    }else if(dataTerminoTarefa.value === ""){
        dataTerminoTarefa.value = "";
        alert("Data de Término não Informada!");
        return ;
    }else if(prioridadeTarefa.value === ""){
        prioridadeTarefa.value = "";
        alert("Prioridade não Informada!");
        return ;
    }else if(prioridadeTarefa.value < 1 || prioridadeTarefa.value > 5){
        prioridadeTarefa.value = "";
        alert("Prioridade Inválida!");
        return ;
    } else if(categoriaTarefa.value === ""){
        categoriaTarefa.value = "";
        alert("Categoria não Informada!");
        return ;
    }else if(statusTarefa.value === ""){
        statusTarefa.value = "";
        alert("Status não Informado!");
        return ;
    }

    tarefa.push([nomeTarefa.value, descricaoTarefa.value, dataTerminoTarefa.value, Number(prioridadeTarefa.value), categoriaTarefa.value, statusTarefa.value]);

    salva.adicionarTarefa(tarefa);
    console.log(tarefa);

    limparCampos();
    listarTarefa();

}

function listarTarefa(){
    
    let saida = "";
    let x = 0;

    while(x < tarefa.length){
            
        salva.tarefaList.forEach((tarefa) => {
            saida += `<div class="tarefa_dados"><div id="nome"><p>${tarefa[x][0]}</p></div><div id="descricao"><p>${tarefa[x][1]}</p></div><div id="dataTermino"><p>${tarefa[x][2]}</p></div><div id="prioridade"><p>${tarefa[x][3]}</p></div><div id="categoria"><p>${tarefa[x][4]}</p></div><div id="status"><p>${tarefa[x][5]}</p></div></div>` 
            
        x++;
        }); 
        
        listaTarefa.innerHTML = saida;
    }
    
}

function limparTarefa(){

    listaTarefa.innerHTML = "";
    salva.limpar();
    tarefa.splice(0, tarefa.length);

}

function listarUmaTarefa(){
    
    let saida = "";
    let x = 0, y = 0;

    let nome = prompt("Digite o nome da tarefa!");
   
    while(x < tarefa.length){
        while(y < 6){
            if(tarefa[x][y] === nome){
                
                limparCampos();

                saida += `<div class="tarefa_dados"><div id="nome"><p>${tarefa[x][0]}</p></div><div id="descricao"><p>${tarefa[x][1]}</p></div><div id="dataTermino"><p>${tarefa[x][2]}</p></div><div id="prioridade"><p>${tarefa[x][3]}</p></div><div id="categoria"><p>${tarefa[x][4]}</p></div><div id="status"><p>${tarefa[x][5]}</p></div></div>`
                listaTarefa.innerHTML = saida;

            }
            y = y + 6;
        }
        x++;
        y = 0;
    }

}

function modificarTarefa(){

    let valor = Boolean(false);

    let nome = prompt("Digite o nome da tarefa!");
    let x = 0, z = 0;
   
    while(x < tarefa.length){
        if(tarefa[x][0] === nome){
            z = x;
            valor = true;
            break;
        }
        x++;
    }

    if(valor === true) {
        let novoNome = prompt("New Nome!");
        let novaDescricao = prompt("New Descrição!");
        let novaDataTermino = prompt("New Data de Término!");
        let novaPrioridade = prompt("New Prioridade!");
        let novaCategoria = prompt("New Categoria!");
        let novoStatus = prompt("New Status!");

        tarefa[z][0] = novoNome;
        tarefa[z][1] = novaDescricao;
        tarefa[z][2] = novaDataTermino;
        tarefa[z][3] = novaPrioridade;
        tarefa[z][4] = novaCategoria;
        tarefa[z][5] = novoStatus;

        listaTarefa.innerHTML = "";

        listarTarefa();

        alert("Tarefa Alterada com Sucesso!");
    }else {
        alert("Tarefa Inexistente!")
        modificarTarefa();
    }

}

function Validar(){

}

function limparCampos(){
    
    nomeTarefa.value = "";
    descricaoTarefa.value = "";
    dataTerminoTarefa.value = "";
    prioridadeTarefa.value = "";
    categoriaTarefa.value = "";
    statusTarefa.value = "";
}
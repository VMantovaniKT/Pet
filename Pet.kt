import kotlin.system.exitProcess
class VirtualPet(val nome: String) {

    var nivelDeFome = 0
    var nivelDeFelicidade = 100
    var nivelDeCansado = 0
    var idade = 0
    var nivelDeBanheiro = 0
    var nivelDeSujeira = 0

fun alimentar() {
        nivelDeFome -= 10
        nivelDeBanheiro += 10
        println("$nome foi alimentado. O nível de fome diminuiu e a vontade de usar o banheiro aumentou!.")
        passarTempo()
    }

    fun brincar() {
        nivelDeFelicidade += 10
        nivelDeSujeira += 10
        nivelDeCansado += 5
        nivelDeFome += 3
        println("$nome está brincando e se sentindo mais feliz. Mas, com mais fome, mais cansaço e mais sujo.")


    }

    fun verificarStatus() {
        println("Status atual de $nome:")
        println("Nível de fome: $nivelDeFome")
        println("Nível de felicidade: $nivelDeFelicidade")
        println("Nivel de cansaço: $nivelDeCansado")
        println("Idade do pet: $idade")
        println("Nivel de sujeira do pet: $nivelDeSujeira")
        println("Vontade de ir ao banheiro do pet: $nivelDeBanheiro")
    }

    fun passarTempo() {
        nivelDeFome += 3
        idade += 1
        nivelDeCansado += 10
        nivelDeFelicidade -= 15
    }

    fun descansar() {
        println("Quanto tempo você quer colocar o seu pet para descansar?(em horas)")
        val tempoDeDescanso = readln().toDouble()
        val reducaoDeCansaso = (tempoDeDescanso / 8.0) * 100
        nivelDeCansado -= reducaoDeCansaso.toInt()

        if (nivelDeCansado <= 0) {
            nivelDeCansado = 0
            println("$nome descansou por $tempoDeDescanso horas e está se sentindo mais revigorado!")
            println("Seu nivel de cansaço atual é $nivelDeCansado")
        }

        passarTempo()
    }

    fun banheiro(){
        println("Você levou $nome ao banheiro.")
        if(true){
            nivelDeBanheiro = 0
            println("A vontade dele de fazer pipi agora é 0!")
        }
        passarTempo()
    }

    fun limparPet(){
        println("Você limpou o(a) $nome.")
        if(true){
            nivelDeSujeira = 0
            println("Está limpinho novamente!")
        }
        passarTempo()

    }

    fun verificar() {
        if (idade >= 50) {
            println("Parabéns, seu pet chegou à idade 50. Você venceu!")
            exitProcess(0)
        }

        if (nivelDeCansado >= 100) {
            println("Seu pet ficou muito cansado, o nivel de cansaço passou de 100, e faleceu!")
            exitProcess(0)
        }

        if (nivelDeFome >= 100) {
            println("Você é um monstro, e não alimentou seu pet, o nivel de fome passou de 100 e ele veio a óbito!")
            exitProcess(0)
        }

        if (nivelDeFelicidade <= 0) {
            println("O nivel de felicidade do seu pet, ficou a baixo de 0. Seu pet morreu de depressão!")
            exitProcess(0)
        }

        if (nivelDeBanheiro >= 100) {
            println("Você não levou seu pet ao banheiro, e ele teve problemas!")
            exitProcess(0)
        }

        if(nivelDeSujeira >= 100) {
        println("Você não cuidou do espaço do seu pet. Ele foi levado para o programa 'Acumuladores Compulsivos'. Você nunca mais o verá! ")
           exitProcess(0)
        }



    }
}
fun main() {
    println("Bem-vindo ao Simulador de Animal de Estimação Virtual!")
    println("A cada ação que seu pet fizer, o tempo irá passar.")
    println("Digite o nome do seu animal de estimação:")
    val nomePet = readLine() ?: ""
    val pet = VirtualPet(nomePet)

    while (true) {
        println("\nEscolha uma ação:")
        println("1. Alimentar $nomePet")
        println("2. Brincar com $nomePet")
        println("3. Botar o $nomePet para descansar.")
        println("4. Levar o $nomePet ao banheiro.")
        println("5. Limpar o cantinho do $nomePet.")
        println("6. Verificar o status de $nomePet.")
        println("7. Sair")

        val escolha = readLine()?.toIntOrNull() ?: continue

        when (escolha) {
            1 -> pet.alimentar()
            2 -> pet.brincar()
            3 -> pet.descansar()
            4 -> pet.banheiro()
            5 -> pet.limparPet()
            6 -> pet.verificarStatus()
            7 -> {
                println("Saindo do Simulador de Animal de Estimação Virtual. Adeus!")
                exitProcess(0)
            }

            else -> println("Escolha inválida. Tente novamente.")
        }
        pet.verificar()
    }

}
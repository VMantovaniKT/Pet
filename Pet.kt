import kotlin.system.exitProcess
class VirtualPet(val nome: String) {

    var nivelDeFome = 50
    var nivelDeFelicidade = 50
    var nivelDeCansado = 0
    var idade = 0

    fun alimentar() {
        nivelDeFome -= 10
        println("$nome foi alimentado. O nível de fome diminuiu.")
        passarTempo()
    }

    fun brincar() {
        nivelDeFelicidade += 10
        println("$nome está brincando e se sentindo mais feliz.")
        nivelDeCansado += 5
        println("$nome está ficando mais cansado ao brincar.")

    }

    fun verificarStatus() {
        println("Status atual de $nome:")
        println("Nível de fome: $nivelDeFome")
        println("Nível de felicidade: $nivelDeFelicidade")
        println("Nivel de cansaço: $nivelDeCansado")
        println("Idade do pet: $idade")
    }

    fun passarTempo() {
        nivelDeFome += 3
        idade += 1
        nivelDeCansado += 10
        nivelDeFelicidade -= 3
    }

    fun descansar(){

    nivelDeCansado -= 10
    println("$nome está descansando !! zzZZZzzzZZZzzz.")
}


    fun verificar() {
        if (idade > 50) {
            println("Parabéns, seu pet chegou à idade 50. Você venceu!")
            exitProcess(0)
        }
        if (nivelDeCansado > 100) {
            println("Seu pet ficou muito cansado, o nivel de cansaço passou de 100, e faleceu!")
            exitProcess(0)
        }
        if (nivelDeFome > 100) {
            println("Você é um monstro, e não alimentou seu pet, o nivel de fome passou de 100 e ele veio a óbito!")
            exitProcess(0)
        }
        if (nivelDeFelicidade <= 0) {
            println("O nivel de felicidade do seu pet, ficou a baixo de 0. Seu pet morreu de depressão!")
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
        println("4. Verificar o status de $nomePet.")
        println("5. Sair")

        val escolha = readLine()?.toIntOrNull() ?: continue

        when (escolha) {
            1 -> pet.alimentar()
            2 -> pet.brincar()
            3 -> pet.descansar()
            4 -> pet.verificarStatus()
            5 -> {
                println("Saindo do Simulador de Animal de Estimação Virtual. Adeus!")
                exitProcess(0)
            }
            else -> println("Escolha inválida. Tente novamente.")
        }
       pet.verificar()
    }
    
}
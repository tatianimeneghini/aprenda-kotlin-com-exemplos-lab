enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nomeUsuario: String, var email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Inscrito agora: $inscritos em ${conteudos.map { it.nome }}")
    }
}

fun main() {
    val usuario1: Usuario = Usuario("Ana", "ana@mail.com")
    val conteudo1: ConteudoEducacional = ConteudoEducacional(
        "Abstraindo Formações da DIO Usando Orientação a Objetos com Kotlin",
        2,
        Nivel.INTERMEDIARIO
    )
    val conteudo2: ConteudoEducacional = ConteudoEducacional(
        "Conhecendo o Kotlin e Sua Documentação Oficial",
        1,
        Nivel.BASICO
    )
    val formacao1: Formacao = Formacao("Code Update TQi - Backend com Kotlin e Java",
        listOf<ConteudoEducacional>(conteudo1, conteudo2)
    )
    formacao1.matricular(usuario1)

    val usuario2: Usuario = Usuario("João", "joaojoao@mail.com")
    val conteudo3: ConteudoEducacional = ConteudoEducacional(
        "Kubernetes Fundamentals",
        19,
        Nivel.DIFICIL
    )
    val formacao3: Formacao = Formacao("Code Update TQi - Backend com Kotlin e Java",
        listOf<ConteudoEducacional>(conteudo3)
    )
    formacao3.matricular(usuario2)
}

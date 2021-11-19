package com.tihasg.rxjava.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class BranchGetResponse(
    @Json(name = "apelido")
    val apelido: String?,

    @Json(name = "bandeira")
    val bandeira: Int?,

    @Json(name = "cnpj")
    val cnpj: String?,

    @Json(name = "codigo")
    val codigo: Int?,

    @Json(name = "dataInauguracao")
    val dataInauguracao: String?,

    @Json(name = "empresa")
    val empresa: Int?,

    @Json(name = "endereco")
    val endereco: AddressResponse?,

    @Json(name = "gerenciaRegional")
    val gerenciaRegional: Int?,

    @Json(name = "implantacoes")
    val implantacoes: DeploymentPointInformation?,

    @Json(name = "implantada")
    val implantada: Boolean?,

    @Json(name = "razaoSocial")
    val razaoSocial: String?
)

@JsonClass(generateAdapter = true)
class AddressResponse(
    @Json(name = "bairro")
    val bairro: String?,

    @Json(name = "cep")
    val cep: String?,

    @Json(name = "complementoLogradouro")
    val complementoLogradouro: String?,

    @Json(name = "logradouro")
    val logradouro: String?,

    @Json(name = "logradouroResumido")
    val logradouroResumido: String?,

    @Json(name = "municipio")
    val municipio: Int?,

    @Json(name = "nomeMunicipio")
    val nomeMunicipio: String?,

    @Json(name = "nomeUf")
    val nomeUf: String?,

    @Json(name = "numeroLogradouro")
    val numeroLogradouro: String?,

    @Json(name = "uf")
    val uf: String?
)

@JsonClass(generateAdapter = true)
class DeploymentPointInformation(
    @Json(name = "acessoAtendeMais")
    val acessoAtendeMais: Boolean?,

    @Json(name = "assinaturaEletronicaSegurosServicos")
    val assinaturaEletronicaSegurosServicos: Boolean?,

    @Json(name = "botaoImpressaoAssinaturaEletronica")
    val botaoImpressaoAssinaturaEletronica: Boolean?,

    @Json(name = "dataAPartirDeCalendarioViaMais")
    val dataAPartirDeCalendarioViaMais: Boolean?,

    @Json(name = "eliminarImpressaoPV")
    val eliminarImpressaoPV: Boolean?,

    @Json(name = "entregaLevesCaudaLonga")
    val entregaLevesCaudaLonga: Boolean?,

    @Json(name = "enviarSms")
    val enviarSms: Boolean?,

    @Json(name = "enviarWhatsApp")
    val nomeUf: Boolean?,

    @Json(name = "excecaoPrecoMostruario")
    val excecaoPrecoMostruario: Boolean?,

    @Json(name = "gerarFtRetiraSaiLoja")
    val gerarFtRetiraSaiLoja: Boolean?,

    @Json(name = "irServicos")
    val irServicos: Boolean?,

    @Json(name = "montagemComoServicoTecnico")
    val montagemComoServicoTecnico: Boolean?,

    @Json(name = "mostrarComboServicos")
    val mostrarComboServicos: Boolean?,

    @Json(name = "novaComercializacaoCelular")
    val novaComercializacaoCelular: Boolean?,

    @Json(name = "novoCalculoFreteProdutosPesados")
    val novoCalculoFreteProdutosPesados: Boolean?,

    @Json(name = "novoModeloNegociacao")
    val novoModeloNegociacao: Boolean?,

    @Json(name = "novoModeloRemuneracao")
    val novoModeloRemuneracao: Boolean?,

    @Json(name = "permitirVendaProdutoB2C")
    val permitirVendaProdutoB2C: Boolean?,

    @Json(name = "pesquisaEligibilidade")
    val pesquisaEligibilidade: Boolean?,

    @Json(name = "psFrete")
    val psFrete: Boolean?,

    @Json(name = "vendaProdutoB2C")
    val vendaProdutoB2C: Boolean?,

    @Json(name = "visualizarModalOptins")
    val visualizarModalOptins: Boolean?
)

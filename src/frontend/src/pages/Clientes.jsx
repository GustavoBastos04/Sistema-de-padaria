import { useEffect, useState } from "react";
import {Table, Button} from "react-bootstrap";
import ItemCliente from "../components/ListItems/ItemCliente.jsx";
import SearchInput from "../components/SearchInputs/SearchInput.jsx";
import { api } from "../services/api.js";

function Clientes() {

    const [clients, setClients] = useState([]);

    const [currentPage, setCurrentPage] = useState(1)
    const [searchItem, setSearchItem] = useState("")
    const itensPerPage = 10

    const indexOfLastItem = currentPage * itensPerPage
    const indexOfFirstItem = indexOfLastItem - itensPerPage
    
    const filteredItems = clients.filter((item) => item.nome.toLowerCase().includes(searchItem))
    const currentItems = filteredItems.slice(indexOfFirstItem, indexOfLastItem)

    const totalPages = Math.ceil(filteredItems.length/itensPerPage)

    const handlePageChange = (pageNumber) => {
        setCurrentPage(pageNumber)
    }

    const handleSearch = (term) => {
        setSearchItem(term.toLowerCase())
        setCurrentPage(1)
    }

    async function loadClients() {
        const items = []
        try {
            const clients = await api.get('cliente')
            const spents = await api.get('desconto-cliente')

            console.log(clients, spents)
    
            if (Array.isArray(clients.data) && Array.isArray(spents.data)) {
                clients.data.forEach(item => {
                    const found = spents.data.find(({cpf}) => cpf === item.cpf)
                    if (found) {
                        const newItem = {
                            nome: item.nome,
                            tipo_de_assinatura: item.tipo_de_assinatura,
                            telefone: item.telefone,
                            email: item.email,
                            cep: item.cep,
                            total_gasto: found.total_gasto,
                            desconto: found.desconto,
                            total_com_desconto: found.total_com_desconto,
                        }
                        items.push(newItem)
                    }
                })
            } else {
                console.error("products.data ou qtd.data não são arrays.")
            }
        } catch (error) {
            console.error("Erro ao carregar dados:", error)
        }
        setClients(items)
    }

    useEffect(() => {
        loadClients()
    }, [])

    return (
        <div>
            <SearchInput string="nome do cliente" onSearch={handleSearch}/>
            <Table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Tipo de assinatura</th>
                        <th>Telefone</th>
                        <th>E-mail</th>
                        <th>CEP</th>
                        <th>Total gasto</th>
                        <th>Desconto</th>
                        <th>Total gasto com desconto</th>
                    </tr>
                </thead>
                <tbody>
                {
                    currentItems.map((item) => {
                            return(
                                <ItemCliente
                                key={`${item.nome}-${item.email}-${item.cep}`} 
                                nome={item.nome}
                                tipo_de_assinatura={item.tipo_de_assinatura}
                                telefone={item.telefone}
                                email={item.email}
                                cep={item.cep}
                                total_gasto={item.total_gasto}
                                desconto={item.desconto}
                                total_com_desconto={item.total_com_desconto}
                                flag={1}
                                />
                            )
                        })
                    }
                </tbody>
            </Table>
            <div className="pagination d-flex justify-content-center align-itens-center">
                    {Array.from({length: totalPages}, (_, index) => (
                        <Button
                        key={index+1}
                        onClick={() => handlePageChange(index+1)}
                        variant={currentPage === index + 1 ? "primary" : "outline-primary"}
                        className="m-1"
                        >
                            {index+1}
                        </Button>
                    ))}
            </div>
        </div>
    )
}

export default Clientes
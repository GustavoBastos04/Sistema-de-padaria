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
        const response = await api.get("desconto-cliente")
        console.log(response.data)
        setClients(response.data)
    }

    useEffect(() => {
        loadClients()
    }, [])

    return (
        <div>
            <SearchInput string="nome" onSearch={handleSearch}/>
            <Table className="striped bordered hover">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
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
                                key={item.id} 
                                nome={item.nome}
                                cpf={item.cpf}
                                total={item.total_gasto}
                                desconto={item.desconto}
                                total_c_desconto={item.total_com_desconto}
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
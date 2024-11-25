import { useState } from "react";
import {Table, Button} from "react-bootstrap";
import ItemVenda from "../../components/ListItems/ItemVenda.jsx";
import SearchInput from "../../components/SearchInputs/SearchInput.jsx";
import vendasFakeList from '../../static/vendasFakeList.js'


function HistoricoVendas() {

    const [currentPage, setCurrentPage] = useState(1)
    const [searchItem, setSearchItem] = useState("")
    const itensPerPage = 10

    const indexOfLastItem = currentPage * itensPerPage
    const indexOfFirstItem = indexOfLastItem - itensPerPage
    
    const filteredItems = vendasFakeList.filter((item) => item.data.toLowerCase().includes(searchItem))
    const currentItems = filteredItems.slice(indexOfFirstItem, indexOfLastItem)

    const totalPages = Math.ceil(filteredItems.length/itensPerPage)

    const handlePageChange = (pageNumber) => {
        setCurrentPage(pageNumber)
    }

    const handleSearch = (term) => {
        setSearchItem(term.toLowerCase())
        setCurrentPage(1)
    }

    return (
        <div>
            <SearchInput string="data" onSearch={handleSearch}/>
            <Table className="striped bordered hover">
                <thead>
                    <tr>
                        <th>ID da venda</th>
                        <th>Valor</th>
                        <th>Data</th>
                    </tr>
                </thead>
                <tbody>
                {
                    currentItems.map((item) => {
                            return(
                                <ItemVenda
                                key={item.id} 
                                id_venda={item.id_venda}
                                valor={item.valor}
                                data={item.data}
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

export default HistoricoVendas;
import 'bootstrap/dist/css/bootstrap.min.css'

import {BrowserRouter as Router, Routes, Route} from "react-router-dom"

import MainNavbar from './components/Navbar/MainNavbar.jsx'
import Homepage from './pages/Homepage.jsx'
import Produtos from './pages/Produtos.jsx'
import Estoque from './pages/Estoque.jsx'
import Clientes from './pages/Clientes.jsx'
import Fornecedores from "./pages/Fornecedores.jsx"
import HistoricoVendas from './pages/Historicos/HistoricoVendas.jsx'
import HistoricoPagamentos from './pages/Historicos/HistoricoPagamentos.jsx'
import CadastroCliente from "./pages/Cadastros/CadastroCliente.jsx"
import CadastroFornecedor from "./pages/Cadastros/CadastroFornecedor.jsx"
import CadastroProduto from './pages/Cadastros/CadastroProduto.jsx'


function App() {
    return (
        <div className='w-100 min-vh-100'>
            <Router>
                <MainNavbar />
                <Routes>
                    <Route path="/" element={<Homepage />} />
                    <Route path="/produtos" element={<Produtos />} />
                    <Route path="/estoque" element={<Estoque />} />
                    <Route path="/clientes" element={<Clientes />} />
                    <Route path="/fornecedores" element={<Fornecedores />} />
                    <Route path="/pagamentos" element={<HistoricoPagamentos />} />
                    <Route path="/vendas" element={<HistoricoVendas />} />
                    <Route path="/cliente" element={<CadastroCliente />} />
                    <Route path="/fornecedor" element={<CadastroFornecedor />} />
                    <Route path="/produto" element={<CadastroProduto />} />
                </Routes>
            </Router>
        </div>
    )
}

export default App